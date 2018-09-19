package com.digital.api.repository;

import com.digital.api.model.BillingAccount;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingAccountRepository extends ElasticsearchRepository<BillingAccount, String> {
}
