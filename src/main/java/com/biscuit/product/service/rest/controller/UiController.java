package com.biscuit.product.service.rest.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.biscuit.product.service.rest.config.JmsMessageListener;
import com.biscuit.product.service.rest.config.ServiceConfiguration;
import com.biscuit.product.service.rest.error.ProductErrorResponse;
import com.biscuit.product.service.rest.error.ProductFrameworkError;
import com.biscuit.product.service.rest.error.ProductMessage;
import com.biscuit.product.service.rest.types.CacheMetric;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.gson.Gson;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@RestController
public class UiController {

	private static final Logger log = LoggerFactory
			.getLogger(UiController.class);

	@Autowired
	private volatile AmqpTemplate amqpTemplate;

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	@Autowired
	@Qualifier("gson")
	private Gson gson;

	public AmqpTemplate getAmqpTemplate() {
		return amqpTemplate;
	}

	public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

	public ServiceConfiguration getConfig() {
		return config;
	}

	public void setConfig(ServiceConfiguration config) {
		this.config = config;
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	@Autowired
	private ServiceConfiguration config;

	@Autowired
	@Qualifier("cacheManager")
	CacheManager cacheManager;

	@RequestMapping(value = "/ui/cache/metrics", method = { RequestMethod.GET })
	public ModelAndView uiCacheMetrics() {
		List<CacheMetric> stats = cacheMetrics(null);
		Map<String, Object> models = new HashMap<>();
		models.put("stats", stats);
		return new ModelAndView("messages/cache-stats", models);
	}

	@RequestMapping(value = "/ui/greeting", method = { RequestMethod.GET })
	public ModelAndView uiCGreeting() {
		String name = "chase";
		Map<String, Object> models = new HashMap<>();
		models.put("name", name);
		return new ModelAndView("greeting", models);
	}

	@SuppressWarnings("rawtypes")
	@ApiOperation(nickname = "cacheStats", value = "Returns all cache stats", notes = "Returns cache status such as hit and misses for all caches.")
	@RequestMapping(method = { RequestMethod.GET }, value = "/maint/caches/stats", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid request", response = ProductErrorResponse.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ProductErrorResponse.class), })
	public List<Metric> allCacheStats() {
		return cacheStats(null);
	}

	@SuppressWarnings("rawtypes")
	@ApiOperation(nickname = "cacheStats", value = "Returns cache stats", notes = "Returns cache stats for a particular cache")
	@RequestMapping(method = { RequestMethod.GET }, value = "/maint/caches/{name}/stats", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid request", response = ProductErrorResponse.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ProductErrorResponse.class), })
	public List<Metric> getCacheStats(
			@ApiParam(name = "name", value = "The cache name.", required = true) @PathVariable("name") String name) {
		List<Metric> statList = cacheStats(name);
		return statList;
	}

	@ApiOperation(nickname = "cacheStats", value = "Returns all cache stats", notes = "Returns cache status such as hit and misses for all caches.")
	@RequestMapping(method = { RequestMethod.GET }, value = "/maint/caches/metrics", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid request", response = ProductErrorResponse.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ProductErrorResponse.class), })
	public List<CacheMetric> allCacheMetrics() {
		return this.cacheMetrics(null);
	}

	@ApiOperation(nickname = "cacheStats", value = "Returns cache stats", notes = "Returns cache stats for a particular cache")
	@RequestMapping(method = { RequestMethod.GET }, value = "/maint/caches/{name}/metrics", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid request", response = ProductErrorResponse.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ProductErrorResponse.class), })
	public List<CacheMetric> getCacheMetrics(
			@ApiParam(name = "name", value = "The cache name.", required = true) @PathVariable("name") String name) {
		return this.cacheMetrics(name);
	}

	@SuppressWarnings("unused")
	private List<CacheMetric> cacheMetrics(String cacheName) {
		List<CacheMetric> statList = new ArrayList<>();
		Iterator<String> names = cacheManager.getCacheNames().iterator();
		while (names.hasNext()) {
			String name = names.next();

			boolean keep = true;
			if (cacheName != null && !cacheName.equals(name)) {
				keep = false;
			}

			if (keep) {
				Object nativeCache = cacheManager.getCache(name)
						.getNativeCache();
				if (nativeCache instanceof Cache<?, ?>) {
					Cache<?, ?> googleCache = (Cache<?, ?>) nativeCache;
					CacheStats stats = googleCache.stats();
					String prefix = name + ".";
					if (stats != null) {
						CacheMetric cm = new CacheMetric();
						long requests = stats.requestCount();
						long hits = stats.hitCount();
						double roundedHitRate = stats.hitRate();
						roundedHitRate = Math.round(roundedHitRate * 1000.0) / 1000.0;
						cm.setCacheName(name);
						cm.setRequestCount(requests);
						cm.setHitCount(hits);
						cm.setMissCount(stats.missCount());
						cm.setSize(googleCache.size());
						cm.setHitRate(roundedHitRate);
						statList.add(cm);
					}
				}
			}
		}
		return statList;
	}

	@SuppressWarnings("rawtypes")
	private List<Metric> cacheStats(String cacheName) {
		List<Metric> statList = new ArrayList<>();
		Iterator<String> names = cacheManager.getCacheNames().iterator();
		while (names.hasNext()) {
			String name = names.next();

			boolean keep = true;
			if (cacheName != null && !cacheName.equals(name)) {
				keep = false;
			}

			if (keep) {
				Object nativeCache = cacheManager.getCache(name)
						.getNativeCache();
				if (nativeCache instanceof Cache<?, ?>) {
					Cache<?, ?> googleCache = (Cache<?, ?>) nativeCache;
					CacheStats stats = googleCache.stats();
					String prefix = name + ".";
					if (stats != null) {
						statList.add(new Metric<Number>(prefix + "size",
								googleCache.size()));
						statList.add(new Metric<Number>(prefix
								+ "request_count", stats.requestCount()));
						statList.add(new Metric<>(prefix + "hit_count", stats
								.hitCount()));
						statList.add(new Metric<Number>(prefix + "hit_rate",
								Math.round(stats.hitRate() * 1000) / 1000));
						statList.add(new Metric<>(prefix + "miss_count", stats
								.missCount()));
						statList.add(new Metric<Number>(prefix + "miss_rate",
								Math.round(stats.missRate() * 1000) / 1000));
					}
				}
			}
		}

		return statList;
	}

	@ApiOperation(nickname = "clearCache", value = "Clears the cache", notes = "Purges all the cache values for a particular cache.")
	@RequestMapping(method = { RequestMethod.GET }, value = "/maint/caches/{name}/clear", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid request", response = ProductErrorResponse.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ProductErrorResponse.class), })
	public void clearCache(
			@ApiParam(name = "name", value = "The cache name.", required = true) @PathVariable("name") String name,
			@ApiParam(name = "rabbit", value = "The rabbit MQ flag.", required = true) @RequestParam(name = "rabbit", required = false, defaultValue = "0") String rabbit) {

		if (cacheManager.getCache(name) != null) {
			cacheManager.getCache(name).clear();
			log.info("Manually clearing cache: " + name);

			boolean enable = false;
			log.info("rabbit flag" + rabbit);
			log.info("rabbitmq.enable"
					+ config.getPropertyValue("rabbitmq.enable"));
			if (config.getString("rabbitmq.enable", "false").equals("true")) {
				enable = true;
			}
			log.info("amqpTemplate " + amqpTemplate);

			if ("1".equals(rabbit) && enable && amqpTemplate != null) {
				String exchange = config
						.getPropertyValue("rabbitmq.exchange.name");
				log.info("Attempting to send rabbit MQ message...");
				try {
					amqpTemplate.convertAndSend(exchange, "",
							JmsMessageListener.CLEAR_CACHE + name);
					log.info("Attempting to send rabbit MQ message...COMPLETE!");
				} catch (Exception err) {
					log.warn("Exception calling rabbit MQ!");
					ProductFrameworkError fe = new ProductFrameworkError(
							"CACHE_RABBITMQ_ERROR", err);
					fe.setErrorMessage(new ProductMessage(
							"CACHE_RABBITMQ_ERROR",
							"The specified cache does not exist"));
					String rootStr = err.getMessage();
					Map<String, Object> details = new HashMap<String, Object>();
					details.put("rootcause", rootStr);
					fe.setDetails(details);
				}

			}
		} else {
			throw new ProductFrameworkError("CACHE_DOES_NOT_EXIST",
					"The specified cache does not exist");
		}
	}

	@ApiOperation(nickname = "clearAllCaches", value = "Clears All caches", notes = "Purges all cache values for a all caches.")
	@RequestMapping(method = { RequestMethod.GET }, value = "/maint/caches/clearall", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid request", response = ProductErrorResponse.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ProductErrorResponse.class), })
	public void clearAllCaches(
			@ApiParam(name = "rabbit", value = "The rabbit MQ flag.", required = true) @RequestParam(name = "rabbit", required = false, defaultValue = "0") String rabbit) {

		if (cacheManager != null && !cacheManager.getCacheNames().isEmpty()) {
			log.debug("" + cacheManager.getCacheNames().size());
			for (String name : cacheManager.getCacheNames()) {
				cacheManager.getCache(name).clear();
				log.info("Manually clearing cache: " + name);
			}

			boolean enable = false;
			log.info("rabbit flag: " + rabbit);
			log.info("rabbitmq.enable: "
					+ config.getPropertyValue("rabbitmq.enable"));
			if (config.getString("rabbitmq.enable", "false").equals("true")) {
				enable = true;
			}

			if ("1".equals(rabbit) && enable && amqpTemplate != null) {
				String exchange = config
						.getPropertyValue("rabbitmq.exchange.name");
				log.info("Attempting to send rabbit MQ message...");
				try {
					amqpTemplate.convertAndSend(exchange, "",
							JmsMessageListener.CLEAR_ALL_CACHES);
					log.info("Attempting to send rabbit MQ message...COMPLETE!");
				} catch (Exception err) {
					log.warn("Exception calling rabbit MQ!");
					ProductFrameworkError fe = new ProductFrameworkError(
							"CACHE_RABBITMQ_ERROR", err);
					fe.setErrorMessage(new ProductMessage(
							"CACHE_RABBITMQ_ERROR",
							"The specified cache does not exist"));
					String rootStr = err.getMessage();
					Map<String, Object> details = new HashMap<String, Object>();
					details.put("rootcause", rootStr);
					fe.setDetails(details);
				}
			}
		} else {
			throw new ProductFrameworkError("CACHES_DO_NOT_EXIST",
					"The cache manager does not exist");
		}
	}

}
