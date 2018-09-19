package com.digital.api.service;

import com.digital.api.model.AccountTaxExemption;
import com.digital.api.model.FinancialAccount;
import com.digital.api.repository.AccountTaxExemptionRepository;
import com.digital.api.repository.FinancialAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FinancialAccountServiceImpl implements FinancialAccountService {

    @Autowired
    private FinancialAccountRepository financianAccountRepository;

    @Autowired
    private AccountTaxExemptionRepository accountTaxExemptionRepository;

    @Override
    public Optional<AccountTaxExemption> getAccountTaxExemptionById(String id) {
        return accountTaxExemptionRepository.findById(id);
    }

    @Override
    public Optional<FinancialAccount> getFinancialAccountById(String id) {
        return financianAccountRepository.findById(id);
    }

    @Override
    public List<FinancialAccount> getAllFinancialAccount() {

        List<FinancialAccount> financialAccountList = new ArrayList<>();
        financianAccountRepository.findAll().forEach(
                finantialAccount -> financialAccountList.add(finantialAccount)
        );
        return financialAccountList;
    }

}
