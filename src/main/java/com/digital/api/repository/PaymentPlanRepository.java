package com.digital.api.repository;

import com.digital.api.model.PaymentPlan;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentPlanRepository extends ElasticsearchRepository<PaymentPlan, String> {
}
