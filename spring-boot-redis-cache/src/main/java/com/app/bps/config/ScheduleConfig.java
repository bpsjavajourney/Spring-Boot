package com.app.bps.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *  
 * ScheduleConfig - provides schedulers to remove the cached entries from the cache.
 * 
 * This can be set to RedisCacheManager entryTtl also. Refer CacheConfig.java for the reference. 
 * 
 * This class provided to show the scheduler approach.
 * 
 * @author parth
 *
 */
@Configuration
@EnableScheduling
@ConditionalOnProperty(name="caching.scheduler.active")
public class ScheduleConfig {
	
	private Logger logger = LoggerFactory.getLogger(ScheduleConfig.class);
	
		
	
	public ScheduleConfig() {
		super();
		logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ScheduleConfig constructor called$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	/**
	 * 
	 * Removes getItems value from the cache
	 */
	@CacheEvict(value = "allItems")
	@Scheduled(fixedRateString = "${caching.spring.ttl.itemservice.allItems}")
	public void emptyGetItemsCache() {
		logger.info("emptyGetItemsCache method called .....to remove the cached entry of getItems()");
		
	}
	
	/**
	 * 
	 * Removes all items cached entries from the cache
	 */	
	@CacheEvict(value = "items", allEntries = true)
	@Scheduled(fixedRateString = "${caching.spring.ttl.itemservice.items}")
	public void emptylItemsServiceCache() {
		logger.info("emptylItemsServiceCache method called .....to clear the all cached entries of items services...i.e all items");
		
	}

}
