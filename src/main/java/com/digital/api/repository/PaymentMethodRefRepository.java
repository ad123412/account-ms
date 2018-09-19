package com.digital.api.repository;

import com.digital.api.model.PaymentMethodRef;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRefRepository extends ElasticsearchRepository<PaymentMethodRef, String> {
}
