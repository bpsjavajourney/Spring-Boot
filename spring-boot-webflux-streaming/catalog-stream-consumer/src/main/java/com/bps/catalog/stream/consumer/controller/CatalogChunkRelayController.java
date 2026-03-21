package com.bps.catalog.stream.consumer.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bps.catalog.stream.consumer.model.CatalogChunk;
import com.bps.catalog.stream.consumer.model.CatalogCodeRequest;
import com.bps.catalog.stream.consumer.service.CatalogChunkRelayService;

import reactor.core.publisher.Flux;

@RestController
public class CatalogChunkRelayController {

	private final CatalogChunkRelayService catalogChunkRelayService;

	public CatalogChunkRelayController(CatalogChunkRelayService catalogChunkRelayService) {
		this.catalogChunkRelayService = catalogChunkRelayService;
	}

	@PostMapping(
			value = "/catalog/feed/chunks/stream",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_EVENT_STREAM_VALUE
	)
	public Flux<CatalogChunk> streamCatalogChunks(@RequestBody CatalogCodeRequest request) {
		System.out.println("Consumer received request codes: " + request.codes());
		return catalogChunkRelayService.relayCatalogChunks(request);
	}
}
