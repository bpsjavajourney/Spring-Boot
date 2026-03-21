package com.bps.catalog.stream.consumer.model;

public record CatalogItem(
		Long id,
		String code,
		String title,
		String category,
		double price
) {
}