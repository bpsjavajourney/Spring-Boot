package com.app.bps.service;

import java.util.List;

import com.app.bps.entity.Item;

public interface ItemService {

	Item save(Item item);

	Item getItem(long id);

	List<Item> getItems();

	void deleteItem(long id);

	Item update(Item item);

}
