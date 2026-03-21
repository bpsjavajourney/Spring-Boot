package com.bps.catalog.stream.producer.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bps.catalog.stream.producer.model.CatalogDetail;

@Component
public class CatalogDetailRepository {

	public List<CatalogDetail> loadHugeCatalogData(String code) {
		List<CatalogDetail> details = new ArrayList<>();

		for (int i = 1; i <= 120; i++) {
			details.add(new CatalogDetail(
					code + "-DETAIL-" + i,
					"attribute-" + i,
					"value-for-" + code + "-" + i
			));
		}

		return details;
	}
}
