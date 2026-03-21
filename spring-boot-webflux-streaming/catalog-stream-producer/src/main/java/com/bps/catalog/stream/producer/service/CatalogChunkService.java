package com.bps.catalog.stream.producer.service;

import java.time.Duration;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.bps.catalog.stream.producer.model.CatalogChunk;
import com.bps.catalog.stream.producer.model.CatalogCodeRequest;
import com.bps.catalog.stream.producer.model.CatalogDetail;
import com.bps.catalog.stream.producer.repository.CatalogDetailRepository;

import reactor.core.publisher.Flux;

@Service
public class CatalogChunkService {

	private static final int CHUNK_SIZE = 25;

	private final CatalogDetailRepository catalogDetailRepository;

	public CatalogChunkService(CatalogDetailRepository catalogDetailRepository) {
		this.catalogDetailRepository = catalogDetailRepository;
	}

	public Flux<CatalogChunk> streamCatalogChunks(CatalogCodeRequest request) {
		Set<String> requestedCodes = extractRequestedCodes(request);

		return Flux.fromIterable(requestedCodes)
				.concatMap(this::streamChunksByCatalogCode);
	}

	private Flux<CatalogChunk> streamChunksByCatalogCode(String code) {
		List<CatalogDetail> fullCatalogData = catalogDetailRepository.loadHugeCatalogData(code);
		List<List<CatalogDetail>> partitions = partition(fullCatalogData, CHUNK_SIZE);
		int totalChunks = partitions.size();

		return Flux.range(0, totalChunks)
				.map(index -> buildChunk(code, index, totalChunks, partitions.get(index)))
				.delayElements(Duration.ofMillis(400))
				.doOnNext(chunk -> System.out.println(
						"Producer streaming code=" + chunk.code()
								+ ", chunk=" + chunk.chunkNumber()
								+ "/" + chunk.totalChunks()
								+ ", chunkSize=" + chunk.chunkSize()
				));
	}

	private CatalogChunk buildChunk(String code, int index, int totalChunks, List<CatalogDetail> details) {
		return new CatalogChunk(
				code,
				index + 1,
				totalChunks,
				details.size(),
				details
		);
	}

	private Set<String> extractRequestedCodes(CatalogCodeRequest request) {
		if (request == null || request.codes() == null || request.codes().isEmpty()) {
			return Collections.emptySet();
		}

		return new LinkedHashSet<>(request.codes());
	}

	private List<List<CatalogDetail>> partition(List<CatalogDetail> source, int size) {
		if (source == null || source.isEmpty()) {
			return Collections.emptyList();
		}

		int totalSize = source.size();
		int partitionCount = (totalSize + size - 1) / size;
		List<List<CatalogDetail>> partitions = new java.util.ArrayList<>(partitionCount);

		for (int start = 0; start < totalSize; start += size) {
			int end = Math.min(start + size, totalSize);
			partitions.add(source.subList(start, end));
		}

		return partitions;
	}
}