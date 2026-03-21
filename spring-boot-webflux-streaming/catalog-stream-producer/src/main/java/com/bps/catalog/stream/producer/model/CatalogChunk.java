package com.bps.catalog.stream.producer.model;

import java.util.List;

public record CatalogChunk(
		String code,
		int chunkNumber,
		int totalChunks,
		int chunkSize,
		List<CatalogDetail> details
) {
}