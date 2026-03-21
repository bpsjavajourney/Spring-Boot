package com.bps.catalog.stream.producer.model;

public record CatalogDetail(
		String detailId,
		String attributeName,
		String attributeValue
) {
}