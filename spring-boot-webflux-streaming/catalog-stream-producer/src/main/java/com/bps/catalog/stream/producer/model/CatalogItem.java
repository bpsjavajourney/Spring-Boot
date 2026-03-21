package com.bps.catalog.stream.producer.model;

public record CatalogItem(
		Long id,
		String code,
		String title,
		String category,
		double price
) {
}
