package com.biscuit.product.service.rest.types;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class CacheMetric {

	private String cacheName;
	private long requestCount;
	private long hitCount;
	private long missCount;
	private double hitRate;
	private long size;

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public long getRequestCount() {
		return requestCount;
	}

	public void setRequestCount(long requestCount) {
		this.requestCount = requestCount;
	}

	public long getHitCount() {
		return hitCount;
	}

	public void setHitCount(long hitCount) {
		this.hitCount = hitCount;
	}

	public long getMissCount() {
		return missCount;
	}

	public void setMissCount(long missCount) {
		this.missCount = missCount;
	}

	public double getHitRate() {
		return hitRate;
	}

	public void setHitRate(double hitRate) {
		this.hitRate = hitRate;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
}
