package com.digital.api.service;

import com.digital.api.model.*;
import com.digital.api.repository.*;
import com.digital.api.util.FinancialAccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartyAccountServiceImpl implements PartyAccountService {

    @Autowired
    private BillingAccountRepository billingAccountRepository;

    @Autowired
    private SettlementAccountRepository settlementAccountRepository;

    @Autowired
    private FinancialAccountRefRepository financialAccountRefRepository;

    @Autowired
    private PaymentMethodRefRepository paymentMethodRefRepository;

    @Autowired
    private PartyAccountRepository partyAccountRepository;

    @Autowired
    private PaymentPlanRepository paymentPlanRepository;

    @Autowired
    private FinancialAccountUtil financialAccountUtil;

    @Override
    public Optional<FinancialAccountRef> getFinancialAccountRefById(String id) {

        Optional<FinancialAccountRef> optionalFinancialAccountRef =
                financialAccountRefRepository.findById(id);
        FinancialAccountRef financialAccountRef = null;
        if(optionalFinancialAccountRef.isPresent()){

            financialAccountRef = optionalFinancialAccountRef.get();
            financialAccountRef = financialAccountUtil.retrieveFinancialAccountRef(financialAccountRef);
            System.out.println("financialAccountRef returned >>> " + financialAccountRef);
        }
        return Optional.of(financialAccountRef);
    }

    @Override
    public Optional<PaymentPlan> getPaymentPlanById(String id) {
        return paymentPlanRepository.findById(id);
    }

    @Override
    public Optional<PaymentMethodRef> getPaymentMethodRefById(String id) {
        return paymentMethodRefRepository.findById(id);
    }

    @Override
    public Optional<PartyAccount> getPartyAccountById(String id) {
        return partyAccountRepository.findById(id);
    }

    @Override
    public List<PartyAccount> getAllPartyAccounts() {

        List<PartyAccount> partyAccounts = new ArrayList<>();
        partyAccountRepository.findAll().forEach(
                partyAccount -> {
                    partyAccounts.add(partyAccount);
                }
        );
        return partyAccounts;
    }

    @Override
    public Optional<BillingAccount> getBillingAccountById(String id) {
        return billingAccountRepository.findById(id);
    }

    @Override
    public List<BillingAccount> getAllBillingAccounts() {

        List<BillingAccount> billingAccounts = new ArrayList<>();
        billingAccountRepository.findAll().forEach(
                partyAccount -> {
                    billingAccounts.add(partyAccount);
                }
        );
        return billingAccounts;
    }

    @Override
    public Optional<SettlementAccount> getSettlementAccountById(String id) {
        return settlementAccountRepository.findById(id);
    }

    @Override
    public List<SettlementAccount> getAllSettlementAccounts() {
        List<SettlementAccount> settlementAccounts = new ArrayList<>();
        settlementAccountRepository.findAll().forEach(
                settlementAccount -> {
                    settlementAccounts.add(settlementAccount);
                }
        );
        return settlementAccounts;
    }
}
