package com.bps.catalog.stream.producer.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bps.catalog.stream.producer.model.CatalogChunk;
import com.bps.catalog.stream.producer.model.CatalogCodeRequest;
import com.bps.catalog.stream.producer.service.CatalogChunkService;

import reactor.core.publisher.Flux;

@RestController
public class CatalogChunkController {

	private final CatalogChunkService catalogChunkService;

	public CatalogChunkController(CatalogChunkService catalogChunkService) {
		this.catalogChunkService = catalogChunkService;
	}

	@PostMapping(
			value = "/catalog/chunks/stream",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_EVENT_STREAM_VALUE
	)
	public Flux<CatalogChunk> streamCatalogChunks(@RequestBody CatalogCodeRequest request) {
		System.out.println("Producer received request codes: " + request.codes());
		return catalogChunkService.streamCatalogChunks(request);
	}
}