package com.app.bps.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * 
 * 
 * CacheConfig provides CustomConfiguration RedisCacheManager Bean
 * 
 * @author parth
 *
 */

@Configuration
@ConditionalOnProperty(name="caching.scheduler.active", havingValue = "false")
public class CacheConfig {

	private Logger logger = LoggerFactory.getLogger(CacheConfig.class);	
	

	public CacheConfig() {
		super();
		logger.info("##########################################CacheConfig constructor called##########################################");
	}

	/**
	 * RedisCacheManager custom configuration.
	 * 
	 * @param redisConnectionFactory
	 * 
	 * @return RedisCacheManager
	 */

	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {

		logger.info("RedisCacheManager bean created...");

		/*
		 * default cache configuration for items cache -- time-to-live set to 60
		 * seconds. Add if any other required config
		 */

		RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(java.time.Duration.ofSeconds(60));

		/*
		 * allItems cache specific configuration -- time-to-live set to 120 seconds. Add
		 * if any other required config
		 */

		RedisCacheConfiguration allItemsCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(java.time.Duration.ofSeconds(120));

		return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(defaultCacheConfig)
				.withCacheConfiguration("allItems", allItemsCacheConfig)
				// .withCacheConfiguration("otherCache", otherCacheConfig)
				.build();

	}

}
