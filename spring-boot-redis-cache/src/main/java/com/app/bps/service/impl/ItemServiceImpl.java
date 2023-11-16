package com.app.bps.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.app.bps.entity.Item;
import com.app.bps.exception.AppException;
import com.app.bps.service.ItemService;
import com.app.bps.service.repository.ItemRepository;

/**
 * 
 * 
 * ItemServiceImpl -- demonstrates redis cache
 * 
 * @author parth
 *
 */

@Service
public class ItemServiceImpl implements ItemService {

	private Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

	@Autowired
	private ItemRepository itemRepository;

	/**
	 * 
	 * Updates cached entry or creates an cached entry for item if it is not
	 * available.
	 * 
	 * Optionally use @CachePut for the specific purpose. Because already we are
	 * caching at getItem level.
	 * 
	 */

	@Override
	@CachePut(value = "items", key = "#item.id", unless = "#result.price<=0")
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	/**
	 * 
	 * Updates cached entry or creates an cached entry for item if it is not
	 * available.
	 * 
	 * 
	 * Optionally we can use @CacheEvict(value = "items",key="#item.id") to remove
	 * the cached entry when there is an DB update. Again when we try to getItem new
	 * cached entry will be created.
	 * 
	 * This won't update allItems cached entry. So after DB update if you try to
	 * fetch /api/items it will return the cached value(old) of allItems. So use @Caching(evict =
	 * { @CacheEvict(value = "items", key = "#id"), @CacheEvict(value = "allItems")
	 * }) to remove both the cached values in this scenario. So next time when we
	 * fetch the value latest value will be cached.
	 * 
	 */

	@Override
	@CachePut(value = "items", key = "#item.id", unless = "#result.price<=0")
	// @CacheEvict(value = "items", key = "#item.id")
	// @Caching(evict = { @CacheEvict(value = "items", key = "#id"),
	// @CacheEvict(value = "allItems") })
	public Item update(Item item) {

		logger.info("Updating record id:" + item.getId());

		if (itemRepository.existsById(item.getId())) {
			return itemRepository.save(item);
		} else {
			logger.info("update(): Item id:" + item.getId() + " Not found.", "RECORD_NOT_FOUND");
			throw new AppException("Item id:" + item.getId() + " Not found.", "RECORD_NOT_FOUND");
		}
	}

	/**
	 * 
	 * After fetching the value from DB, it create an entry in the redis cache like
	 * "items::#id"
	 * 
	 */

	@Override
	@Cacheable(value = "items", key = "#id", unless = "#result.price<=0")
	public Item getItem(long id) {
		logger.info("getting record id:" + id);
		return itemRepository.findById(id)
				.orElseThrow(() -> new AppException("Item id:" + id + " Not found.", "RECORD_NOT_FOUND"));
	}

	/**
	 * 
	 * After fetching the values from DB, it creates an entry in the redis cache
	 * like "items::#allItems"
	 * 
	 * 
	 * Use this for the specific requirement only. We don't have refresh time here.
	 * So values will not get refreshed.
	 * 
	 * Uncomment @Cacheable and try
	 * 
	 */

	@Override
	@Cacheable("allItems")
	public List<Item> getItems() {
		logger.info("getting all items");
		return itemRepository.findAll();
	}

	/**
	 * 
	 * Deletes cache entries of "items::#id" and "items::#allItems" from the cache
	 * 
	 * 
	 * add allEntries = true to delete allEntries
	 * 
	 */

	@Override
	@Caching(evict = { @CacheEvict(value = "items", key = "#id"), @CacheEvict(value = "allItems") })
	public void deleteItem(long id) {
		logger.info("deleting record id:" + id);
		if (itemRepository.existsById(id)) {
			itemRepository.deleteById(id);
		} else {
			logger.info("deleteItem(): Item id:" + id + " Not found.", "RECORD_NOT_FOUND");
			throw new AppException("Item id:" + id + " Not found.", "RECORD_NOT_FOUND");
		}

	}

}
