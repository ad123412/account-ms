package com.digital.api.service;

import com.digital.api.model.AccountTaxExemption;
import com.digital.api.model.FinancialAccount;

import java.util.List;
import java.util.Optional;


public interface FinancialAccountService {

    public Optional<AccountTaxExemption> getAccountTaxExemptionById(String id);

    public Optional<FinancialAccount> getFinancialAccountById(String id);

    public List<FinancialAccount> getAllFinancialAccount();
}
