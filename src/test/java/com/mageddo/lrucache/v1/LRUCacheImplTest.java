package com.mageddo.lrucache.v1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 11/8/16 3:30 PM
 */
public class LRUCacheImplTest {

	@Test
	public void get() throws Exception {

		final LRUCacheImpl lruCache = new LRUCacheImpl(1);

		final int value = 10;
		final int key = 5;
		final int expectedSize = 1;
		final int expectedValue = 30;

		lruCache.set(key, value);
		Assert.assertEquals(value, lruCache.get(key));
		Assert.assertEquals(value, lruCache.get(key));
		Assert.assertEquals(2, lruCache.cache.get(key).count);
		lruCache.set(key, expectedValue);
		Assert.assertEquals(expectedValue, lruCache.get(key));
		Assert.assertEquals(expectedSize, lruCache.cache.get(key).count);
		Assert.assertEquals(expectedSize, lruCache.cache.size());

	}

	@Test
	public void set() throws Exception {

		final int CACHE_CAPACITY = 3;
		final LRUCacheImpl lruCache = new LRUCacheImpl(CACHE_CAPACITY);

		lruCache.set(5, 30);
		lruCache.set(50, 25);
		lruCache.set(500, 60);

		Assert.assertEquals(30, lruCache.get(5));
		Assert.assertEquals(25, lruCache.get(50));
		Assert.assertEquals(60, lruCache.get(500));

		lruCache.set(5000, 1);
		Assert.assertEquals(-1, lruCache.get(5));
		Assert.assertEquals(25, lruCache.get(50));
		Assert.assertEquals(25, lruCache.get(50));
		Assert.assertEquals(60, lruCache.get(500));
		Assert.assertEquals(1, lruCache.get(5000));
		Assert.assertEquals(CACHE_CAPACITY, lruCache.cache.size());

		lruCache.set(5001, 1);
		Assert.assertEquals(-1, lruCache.get(5000));
		Assert.assertEquals(1, lruCache.get(5001));
		Assert.assertEquals(CACHE_CAPACITY, lruCache.cache.size());

		lruCache.set(50, 1);
		Assert.assertEquals(CACHE_CAPACITY, lruCache.cache.size());
		Assert.assertEquals(1, lruCache.get(50));
		Assert.assertEquals(1, lruCache.get(5001));

	}

}