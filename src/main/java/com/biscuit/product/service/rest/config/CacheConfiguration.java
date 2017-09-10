package com.biscuit.product.service.rest.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.guava.CaffeinatedGuava;
import com.google.common.cache.CacheBuilder;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@EnableCaching
@Configuration
public class CacheConfiguration {

	@Autowired
	protected Environment env;

	private static final Logger LOG = LoggerFactory
			.getLogger(CacheConfiguration.class);

	public static final String CACHE_ITEMTYPES = "CACHE_ITEM_TYPES"; // 20
																		// records
	public static final String CACHE_REVERSE_CONFIGS = "CACHE_REVERSE_CONFIGS"; // TBD
	public static final String CACHE_SETTINGS = "CACHE_SETTINGS"; // 50 records
	public static final String CACHE_ITEM_LOCATIONS = "CACHE_LOCATIONS"; // 2
																			// records
	public static final String CACHE_ITEM_STATUSES = "CACHE_STATUSES"; // 20
																		// records
	public static final String CACHE_MARKET_LOCATIONS = "CACHE_MARKET_LOCATIONS"; // 4
																					// records
	public static final String CACHE_MARKET_STATUSES = "CACHE_MARKET_STATUSES"; // 220
																				// records
	public static final String CACHE_CORP_OPRID = "CACHE_CORP_OPRID"; // 200
																		// recors
	public static final String CACHE_DDP_CODEOFDAY = "CACHE_DDP_CODEOFDAY"; // 500
																			// records
	public static final String CACHE_BILLING_SYS_CODES = "CACHE_BILLING_SYS_CODES"; // millions
																					// of
																					// records
	public static final String CACHE_CONFIG_KEYS = "CACHE_CONFIG_KEYS"; // ?
	public static final String CACHE_CORP_DEL_PWD = "CACHE_CORP_DEL_PWD"; // 200
																			// records
	public static final String CACHE_MARKETS = "CACHE_MARKETS"; // 11k records
	public static final String CACHE_CPE_ERR_LG_CFG = "CACHE_CPE_ERR_LG_CFG"; // 8
																				// records
	public static final String CACHE_CPE_CONFIG_MARKETS = "CACHE_CPE_CONFIG_MARKETS"; // 50000+
																						// records
	public static final String CACHE_CPE_CONFIG_MARKETS_CANONICAL = "CACHE_CPE_CONFIG_MARKETS_CANONICAL";
	public static final String CACHE_CPE_CONFIG_MARKETS_ID = "CACHE_CPE_CONFIG_MARKETS_ID";
	public static final String CACHE_DEVICE_CAPABILTIES = "CACHE_DEVICE_CAPABILTIES";
	public static final String CACHE_MODEL_DEVICE_CAPABILTIES = "CACHE_MODEL_DEVICE_CAPABILTIES";
	public static final String CACHE_HEAD_END_VENDOR = "CACHE_HEAD_END_VENDOR";
	public static final String CACHE_HEAD_END_VENDOR_LOCATION = "CACHE_HEAD_END_VENDOR_LOCATION";
	public static final String CACHE_HEAD_END_VENDOR_MARKET = "CACHE_HEAD_END_VENDOR_MARKET";
	public static final String CACHE_CSG_EQUIPMENT_TYPE = "CACHE_CSG_EQUIPMENT_TYPE";

	public static final String ALL_CACHES = "ALL_CACHES";

	private static final String CACHES = "caches.";
	private static final String MAXSIZE = ".maxsize";
	private static final String ENABLED = ".enabled";
	private static final String RECORDSTATS = ".recordstats";
	private static final String EXPIREAFTERWRITE = ".expireAfterWrite";
	private static final String EXPIREAFTERACCESS = ".expireAfterAccess";
	private static final String ISNULLABLE = ".isNullable";

	@Bean(name = "cacheManager")
	public CacheManager cacheManager() {
		// http://codedevstuff.blogspot.com/2015/07/add-guava-cache-to-spring-boot-to-cache.html
		// http://www.jayway.com/2012/04/16/introducing-the-google-guava-cache/
		// https://gist.github.com/marceloverdijk/a8ad372c55f40f302c69
		SimpleCacheManager cacheManager = new SimpleCacheManager();

		List<String> caches = new ArrayList<>();
		caches.addAll(Arrays.asList(CACHE_ITEMTYPES, CACHE_SETTINGS,
				CACHE_ITEM_LOCATIONS, CACHE_ITEM_STATUSES, CACHE_CORP_OPRID,
				CACHE_MARKET_LOCATIONS, CACHE_MARKET_STATUSES,
				CACHE_CORP_OPRID, CACHE_DDP_CODEOFDAY, CACHE_BILLING_SYS_CODES,
				CACHE_CONFIG_KEYS, CACHE_CORP_DEL_PWD, CACHE_MARKETS,
				CACHE_CPE_ERR_LG_CFG, CACHE_CPE_CONFIG_MARKETS,
				CACHE_CPE_CONFIG_MARKETS_CANONICAL,
				CACHE_CPE_CONFIG_MARKETS_ID, CACHE_DEVICE_CAPABILTIES,
				CACHE_MODEL_DEVICE_CAPABILTIES, CACHE_HEAD_END_VENDOR,
				CACHE_HEAD_END_VENDOR_LOCATION, CACHE_HEAD_END_VENDOR_MARKET,
				CACHE_CSG_EQUIPMENT_TYPE));

		// caches.CACHE_CPE_CONFIG_MARKETS_CANONICAL.isNullable=false
		// caches.CACHE_CPE_CONFIG_MARKETS_ID.enabled=true

		List<Cache> cacheList = new ArrayList<>();
		Boolean allEnabled = env.getProperty(CACHES + ALL_CACHES + ENABLED,
				Boolean.class, Boolean.FALSE);
		Integer allMaxsize = env.getProperty(CACHES + ALL_CACHES + MAXSIZE,
				Integer.class, 0);
		Boolean allRecordStats = env.getProperty(CACHES + ALL_CACHES
				+ RECORDSTATS, Boolean.class, Boolean.FALSE);
		Integer allExpireAfterWrite = propInt(CACHES + ALL_CACHES
				+ EXPIREAFTERWRITE);
		Integer allExpireAfterAccess = propInt(CACHES + ALL_CACHES
				+ EXPIREAFTERACCESS);
		Boolean allIsNullable = env.getProperty(CACHES + ALL_CACHES
				+ ISNULLABLE, Boolean.class, Boolean.FALSE);
		for (String cache : caches) {
			LOG.debug("cache " + cache);

			Boolean enabled = env.getProperty(CACHES + cache + ENABLED,
					Boolean.class, allEnabled);
			String type = env.getProperty(CACHES + "type", "GUAVA");
			LOG.info("cache " + cache, "  allEnabled " + allEnabled + "  "
					+ enabled);

			if (enabled) {
				Cache c = null;
				if ("caffeine".equalsIgnoreCase(type)) {
					// do nothing!
					c = caffeineBuilderGuava(cache, allMaxsize, allRecordStats,
							allExpireAfterWrite, allExpireAfterAccess,
							allIsNullable);
				} else {
					c = guavaBuilder(cache, allMaxsize, allRecordStats,
							allExpireAfterWrite, allExpireAfterAccess,
							allIsNullable);
				}

				cacheList.add(c);
			} else {
				LOG.debug("cache NOT enabled!!");
			}
		}

		LOG.debug("cacheList: " + cacheList.size());
		cacheManager.setCaches(cacheList);

		return cacheManager;
	}

	private GuavaCache guavaBuilder(String cache, int allMaxsize,
			boolean allRecordStats, int allExpireAfterWrite,
			int allExpireAfterAccess, boolean allisnullable) {
		LOG.debug("cache enabled!!");
		Integer maxsize = env.getProperty(CACHES + cache + MAXSIZE,
				Integer.class, allMaxsize);
		Boolean recordstats = env.getProperty(CACHES + cache + RECORDSTATS,
				Boolean.class, allRecordStats);
		Integer expireAfterWrite = env.getProperty(CACHES + cache
				+ EXPIREAFTERWRITE, Integer.class, allExpireAfterWrite);
		Integer expireAfterAccess = env.getProperty(CACHES + cache
				+ EXPIREAFTERACCESS, Integer.class, allExpireAfterAccess);
		Boolean isnullable = env.getProperty(CACHES + cache + ISNULLABLE,
				Boolean.class, allisnullable);

		CacheBuilder<Object, Object> cb = CacheBuilder.newBuilder()
				.maximumSize(maxsize);
		if (expireAfterWrite != null) {
			cb = cb.expireAfterWrite(expireAfterWrite, TimeUnit.SECONDS);
		}
		if (expireAfterAccess != null) {
			cb = cb.expireAfterAccess(expireAfterAccess, TimeUnit.SECONDS);
		}
		if (recordstats) {
			cb = cb.recordStats();
		}
		return new GuavaCache(cache, cb.build(), isnullable);
	}

	private GuavaCache caffeineBuilderGuava(String cache, int allMaxSize,
			boolean allRecordStats, int allExpireAfterWrite,
			int allExpireAfterAccess, boolean allisnullable) {
		LOG.debug("cache enabled!!");
		Integer maxsize = env.getProperty(CACHES + cache + MAXSIZE,
				Integer.class, allMaxSize);
		Boolean recordstats = env.getProperty(CACHES + cache + RECORDSTATS,
				Boolean.class, allRecordStats);
		Integer expireAfterWrite = env.getProperty(CACHES + cache
				+ EXPIREAFTERWRITE, Integer.class, allExpireAfterWrite);
		Integer expireAfterAccess = env.getProperty(CACHES + cache
				+ EXPIREAFTERACCESS, Integer.class, allExpireAfterAccess);
		Boolean isnullable = env.getProperty(CACHES + cache + ISNULLABLE,
				Boolean.class, allisnullable);

		Caffeine<Object, Object> cb = Caffeine.newBuilder()
				.maximumSize(maxsize);
		if (expireAfterWrite != null) {
			cb = cb.expireAfterWrite(expireAfterWrite, TimeUnit.SECONDS);
		}
		if (expireAfterAccess != null) {
			cb = cb.expireAfterAccess(expireAfterAccess, TimeUnit.SECONDS);
		}
		if (recordstats) {
			cb = cb.recordStats();
		}

		return new GuavaCache(cache, CaffeinatedGuava.build(cb), isnullable);
	}

	/**
	 * Helper method to get Integer properties.
	 * 
	 * @param property
	 * @return
	 */
	protected Integer propInt(String property) {
		Integer val = null;
		String prop = env.getProperty(property);
		if (prop != null) {
			val = Integer.valueOf(prop);
		}
		return val;
	}

}