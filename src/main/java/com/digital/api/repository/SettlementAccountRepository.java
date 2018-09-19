package com.digital.api.repository;

import com.digital.api.model.SettlementAccount;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementAccountRepository extends ElasticsearchRepository<SettlementAccount, String> {
}
