package com.digital.api.repository;

import com.digital.api.model.AccountTaxExemption;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTaxExemptionRepository extends ElasticsearchRepository<AccountTaxExemption, String> {
}
