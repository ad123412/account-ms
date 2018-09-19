package com.digital.api.service;

import com.digital.api.model.*;

import java.util.List;
import java.util.Optional;

public interface PartyAccountService {

    public Optional<FinancialAccountRef> getFinancialAccountRefById(String id);

    public Optional<PaymentPlan> getPaymentPlanById(String id);

    public Optional<PaymentMethodRef> getPaymentMethodRefById(String id);

    public Optional<PartyAccount> getPartyAccountById(String id);

    public List<PartyAccount> getAllPartyAccounts();

    public Optional<BillingAccount> getBillingAccountById(String id);

    public List<BillingAccount> getAllBillingAccounts();

    public Optional<SettlementAccount> getSettlementAccountById(String id);

    public List<SettlementAccount> getAllSettlementAccounts();
}
