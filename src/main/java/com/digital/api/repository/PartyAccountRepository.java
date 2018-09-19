package com.digital.api.repository;

import com.digital.api.model.PartyAccount;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyAccountRepository extends ElasticsearchRepository<PartyAccount, String> {
}
