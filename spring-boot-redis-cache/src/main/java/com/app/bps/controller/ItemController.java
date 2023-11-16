package com.app.bps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bps.entity.Item;
import com.app.bps.service.ItemService;
/**
 * 
 * 
 * ItemController provide crud operations
 * 
 * @author parth
 *
 */
@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping
	public ResponseEntity<Item> save(@RequestBody Item item) {

		return new ResponseEntity<Item>(itemService.save(item),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Item> update(@RequestBody Item item) {

		return new ResponseEntity<Item>(itemService.update(item),HttpStatus.OK);
	}	

	@GetMapping("/{id}")
	public ResponseEntity<Item> getItem(@PathVariable("id") long id){
		
		return new ResponseEntity<Item>(itemService.getItem(id),HttpStatus.OK);
		
	}

	@GetMapping
	public ResponseEntity<List<Item>> getItems(){
		
		return new ResponseEntity<List<Item>>(itemService.getItems(),HttpStatus.OK);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable("id") long id){
		
		itemService.deleteItem(id);

		ResponseEntity.notFound().build();

		return new ResponseEntity<Void>(HttpStatus.OK);
		
		
	}

}
