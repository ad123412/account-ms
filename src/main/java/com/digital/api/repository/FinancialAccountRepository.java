package com.digital.api.repository;

import com.digital.api.model.FinancialAccount;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialAccountRepository extends ElasticsearchRepository<FinancialAccount, String> {
}
