package com.biscuit.product.service.rest.config;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;

import com.biscuit.product.service.rest.dao.ProductDao;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class JmsMessageListener {

	private CacheManager cacheManager;

	private static final Logger LOG = LoggerFactory
			.getLogger(JmsMessageListener.class);

	public static final String CLEAR_CACHE = "CLEARCACHE:";

	public static final String CLEAR_ALL_CACHES = "CLEAR_ALL_CACHES";

	public JmsMessageListener(CacheManager cacheManager,
			ProductDao customerPremisesEquipmentItemConfigurationForMarketDao) {
		this.cacheManager = cacheManager;
	}

	public void handleMessage(String text) {
		LOG.info("Received: " + text);
		if (StringUtils.isNotBlank(text)) {
			if (text.startsWith(CLEAR_CACHE)) {
				String cacheName = text.substring(CLEAR_CACHE.length());
				clearCache(cacheName);
			} else if (text.startsWith(CLEAR_ALL_CACHES)) {
				if (cacheManager != null
						&& !cacheManager.getCacheNames().isEmpty()) {
					for (String name : cacheManager.getCacheNames()) {
						clearCache(name);
					}
				}
			}
		}
		LOG.info("cacheManager " + cacheManager);
	}

	public void handleMessage(byte[] body) {
		LOG.info("Received: " + body);
		String st = new String(body);
		LOG.info("cacheManager " + cacheManager + " for byte[]: " + st);
		handleMessage(st);
	}

	public void clearCache(String cacheName) {
		if (cacheManager != null && cacheManager.getCache(cacheName) != null) {
			LOG.info("Clearing cache " + cacheName);
			cacheManager.getCache(cacheName).clear();
			LOG.info("Clearing cache COMPLETE!");

		}
	}
}