package com.app.bps.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bps.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
