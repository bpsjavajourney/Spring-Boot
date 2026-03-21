package com.bps.catalog.stream.consumer.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bps.catalog.stream.consumer.model.CatalogChunk;
import com.bps.catalog.stream.consumer.model.CatalogCodeRequest;

import reactor.core.publisher.Flux;

@Service
public class CatalogChunkRelayService {

	private final WebClient producerWebClient;

	public CatalogChunkRelayService(WebClient producerWebClient) {
		this.producerWebClient = producerWebClient;
	}

	public Flux<CatalogChunk> relayCatalogChunks(CatalogCodeRequest request) {
		return producerWebClient.post()
				.uri("/catalog/chunks/stream")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.TEXT_EVENT_STREAM)
				.bodyValue(request)
				.retrieve()
				.bodyToFlux(CatalogChunk.class)
				.doOnSubscribe(subscription ->
						System.out.println("Consumer forwarding request codes: " + request.codes()))
				.doOnNext(chunk ->
						System.out.println(
								"Consumer relaying code=" + chunk.code()
										+ ", chunk=" + chunk.chunkNumber()
										+ "/" + chunk.totalChunks()
										+ ", chunkSize=" + chunk.chunkSize()
						));
	}
}