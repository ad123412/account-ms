package com.digital.api.repository;

import com.digital.api.model.FinancialAccountRef;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialAccountRefRepository extends ElasticsearchRepository<FinancialAccountRef, String> {
}
