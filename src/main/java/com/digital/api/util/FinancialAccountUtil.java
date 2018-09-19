package com.digital.api.util;

import com.digital.api.model.*;
import com.digital.api.service.FinancialAccountServiceImpl;
import com.digital.api.service.PartyAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class FinancialAccountUtil {

    @Value("${contact-ms.base-url}")
    private String contactMsBaseUrl;

    @Value("${billing-ms.base-url}")
    private String billMsBaseUrl;

    @Autowired
    private FinancialAccountServiceImpl financialAccountService;

    @Autowired
    private PartyAccountServiceImpl partyAccountService;

    public FinancialAccount populateFinancialAccount(FinancialAccount financialAccount) throws ExecutionException, InterruptedException {

        CompletableFuture<List<RelatedPartyRef>> listOfRelatedPartyCompletableFuture =
                retrieveRelatedPartyRefs(financialAccount.getRelatedParty());
        Mono<List<RelatedPartyRef>> relatedPartyRefMono = Mono.fromFuture(listOfRelatedPartyCompletableFuture);

        CompletableFuture<List<AccountTaxExemption>> listOfAccountTaxListCompletableFuture =
                retrieveAccountTaxExceptions(financialAccount.getTaxExemption());
        Mono<List<AccountTaxExemption>> accountTaxExemptionMono = Mono.fromFuture(listOfAccountTaxListCompletableFuture);

        CompletableFuture<List<Contact>>  listOfContactCompletableFuture = retrieveContacts(financialAccount.getContact());
        Mono<List<Contact>> contactMono = Mono.fromFuture(listOfContactCompletableFuture);

        CompletableFuture<List<AccountBalance>> listCompletableFuture =
                retrieveAccountBalances(financialAccount.getAccountBalance());
        Mono<List<AccountBalance>> accountBalanceMono = Mono.fromFuture(listCompletableFuture);

        CompletableFuture<List<AccountRelationship>>  listOfAccCompletableFuture =
                retrieveAccountRelationships(financialAccount.getAccountRelationship());
        Mono<List<AccountRelationship>> accountRelationshipMono = Mono.fromFuture(listOfAccCompletableFuture);

        FinancialAccount finalFinancialAccount =
                Mono.zip(relatedPartyRefMono, accountTaxExemptionMono, contactMono, accountBalanceMono, accountRelationshipMono)
                .map(tuple -> {

                    List<RelatedPartyRef> relatedRefFinalList = tuple.getT1();
                    financialAccount.setRelatedParty(relatedRefFinalList);

                    List<AccountTaxExemption> accountTaxExemptionFinalList = tuple.getT2();
                    financialAccount.setTaxExemption(accountTaxExemptionFinalList);

                    List<Contact> contactFinalList = tuple.getT3();
                    financialAccount.setContact(contactFinalList);

                    List<AccountBalance> accountBalanceFinalList = tuple.getT4();
                    financialAccount.setAccountBalance(accountBalanceFinalList);

                    List<AccountRelationship> accountRelationshipFinalList = tuple.getT5();
                    financialAccount.setAccountRelationship(accountRelationshipFinalList);

                    return financialAccount;
                }).block();

        return finalFinancialAccount;
    }

    public CompletableFuture<List<RelatedPartyRef>> retrieveRelatedPartyRefs(List<RelatedPartyRef> relatedPartyRefList){

        return CompletableFuture.<List<RelatedPartyRef>>supplyAsync(
                () -> {
                    List<RelatedPartyRef> finalRelatedPartyRefs = new ArrayList<>();
                    relatedPartyRefList.stream()
                            .forEach(
                                    relatedPartyRef -> {

                                        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(contactMsBaseUrl);
                                        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
                                        WebClient client = WebClient.builder().uriBuilderFactory(factory).build();
                                        Flux<RelatedPartyRef> flux = client.get()
                                                .uri("/account/contact/relatedParty/" + relatedPartyRef.getId())
                                                .accept(MediaType.APPLICATION_JSON)
                                                .retrieve()
                                                .bodyToFlux(RelatedPartyRef.class);
                                        Mono<List<RelatedPartyRef>> relPartyRefMono = flux.collectList();
                                        List<RelatedPartyRef> partyRefLst = relPartyRefMono.block();
                                        System.out.println("relPartyRef >> " + partyRefLst.get(0));
                                        finalRelatedPartyRefs.addAll(partyRefLst);
                                    }
                            );
                    return finalRelatedPartyRefs;
                }
        );
    }

    public CompletableFuture<List<AccountTaxExemption>> retrieveAccountTaxExceptions(
            List<AccountTaxExemption> accountTaxExemptionList){

        return CompletableFuture.<List<AccountTaxExemption>>supplyAsync(
                () -> {
                    List<AccountTaxExemption> finalAccountTaxExemptionList = new ArrayList<>();
                    accountTaxExemptionList.stream()
                            .forEach(
                                    accountTaxExemption -> {
                                        Optional<AccountTaxExemption> accountTaxExemptionOptional =
                                                financialAccountService.getAccountTaxExemptionById(accountTaxExemption.getId());
                                        if(accountTaxExemptionOptional.isPresent()){
                                            finalAccountTaxExemptionList.add(accountTaxExemptionOptional.get());
                                        }
                                    }
                            );
                    return finalAccountTaxExemptionList;
                }
        );
    }

    public CompletableFuture<List<Contact>> retrieveContacts(List<Contact> financialAccountContact){

        return CompletableFuture.<List<Contact>>supplyAsync(

                () -> {
                    List<Contact> contacts = new ArrayList<>();
                    financialAccountContact.stream()
                            .forEach(
                                    contact -> {
                                        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(contactMsBaseUrl);
                                        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
                                        WebClient client = WebClient.builder().uriBuilderFactory(factory).build();
                                        List<Contact> contactsList = client.get()
                                                .uri("/account/contact/" + contact.getId()).accept(MediaType.APPLICATION_JSON)
                                                .retrieve()
                                                .bodyToFlux(Contact.class)
                                                .collectList()
                                                .block();
                                        contacts.addAll(contactsList);
                                    }
                            );
                    return contacts;
                }
        )  ;
    }

    public CompletableFuture<List<AccountBalance>> retrieveAccountBalances(List<AccountBalance> accountBalanceLst){

        return CompletableFuture.<List<AccountBalance>>supplyAsync(() -> {

            List<AccountBalance> accountBalanceList = new ArrayList<>();
            accountBalanceLst.stream()
                    .forEach(
                            accountBalance -> {

                                DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(billMsBaseUrl);
                                factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
                                WebClient client = WebClient.builder().uriBuilderFactory(factory).build();
                                List<AccountBalance> accountBlnsList = client.get()
                                        .uri("/account/balance/" + accountBalance.getId()).accept(MediaType.APPLICATION_JSON)
                                        .retrieve()
                                        .bodyToFlux(AccountBalance.class)
                                        .collectList()
                                        .block();
                                accountBalanceList.addAll(accountBlnsList);
                            }
                    );
            return accountBalanceList;
        });
    }

    public CompletableFuture<List<AccountRelationship>> retrieveAccountRelationships(List<AccountRelationship> accRelationshipLst){

        return CompletableFuture.supplyAsync(() -> {
            List<AccountRelationship> accountRelationships = new ArrayList<>();
            accRelationshipLst.stream()
                    .forEach(
                            accountRelationship -> {

                                DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(billMsBaseUrl);
                                factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
                                WebClient client = WebClient.builder().uriBuilderFactory(factory).build();
                                List<AccountRelationship> accRelationList = client.get()
                                        .uri("/account/relationship/" + accountRelationship.getId()).accept(MediaType.APPLICATION_JSON)
                                        .retrieve()
                                        .bodyToFlux(AccountRelationship.class)
                                        .collectList()
                                        .block();
                                accountRelationships.addAll(accRelationList);
                            }
                    );
            return accountRelationships;
        });
    }

    public FinancialAccountRef retrieveFinancialAccountRef(FinancialAccountRef financialAccountRef){

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(billMsBaseUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
        WebClient client = WebClient.builder().uriBuilderFactory(factory).build();
        List<AccountBalance> accountBalnsList = client.get()
                .uri("/account/balance/" + financialAccountRef.getAccountBalance().getId())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(AccountBalance.class)
                .collectList()
                .block();
        financialAccountRef.setAccountBalance(accountBalnsList.get(0));
        return financialAccountRef;
    }

    public CompletableFuture<List<BillStructure>> retrieveBillStructures(BillStructure billStructure){

        return CompletableFuture.<List<BillStructure>>supplyAsync(
                () -> {
                    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(billMsBaseUrl);
                    factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
                    WebClient client = WebClient.builder().uriBuilderFactory(factory).build();
                    List<BillStructure> billStructureList = client.get()
                            .uri("/account/billStructure/" + billStructure.getId())
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToFlux(BillStructure.class)
                            .collectList()
                            .block();
                    return billStructureList;
                }
        );
    }

    public PartyAccount populatePartyAccount(PartyAccount partyAccount){

        CompletableFuture<List<BillStructure>> listOfBillListCompletableFuture =
                retrieveBillStructures(partyAccount.getBillStructure());
        Mono<List<BillStructure>> billStListMono = Mono.fromFuture(listOfBillListCompletableFuture);

        CompletableFuture<FinancialAccountRef> financialAccountRefCompletableFuture =
                CompletableFuture.<FinancialAccountRef>supplyAsync(
                        () -> {
                            Optional<FinancialAccountRef> financialAccountRefOptional =
                                partyAccountService.getFinancialAccountRefById(partyAccount.getFinancialAccount().getId());
                            if(financialAccountRefOptional.isPresent()){
                                return  financialAccountRefOptional.get();
                            }
                            return null;
                        }
                );
        Mono<FinancialAccountRef> financialAccountRefMono = Mono.fromFuture(financialAccountRefCompletableFuture);

        CompletableFuture<List<PaymentPlan>> listOfPaymentListCompletableFuture =
                CompletableFuture.<List<PaymentPlan>>supplyAsync(() -> {
                    List<PaymentPlan> finalListPaymentPlans = new ArrayList<>();
                    partyAccount.getPaymentPlan().stream()
                            .forEach(
                                    element -> {
                                        Optional<PaymentPlan> optionalPaymentPlan =
                                                partyAccountService.getPaymentPlanById(element.getId());
                                        if(optionalPaymentPlan.isPresent()){
                                            finalListPaymentPlans.add(optionalPaymentPlan.get());
                                        }
                                    }
                            );
                    return finalListPaymentPlans;
                });
        Mono<List<PaymentPlan>> listOfPaymentPlanMono = Mono.fromFuture(listOfPaymentListCompletableFuture);

        CompletableFuture<PaymentMethodRef> paymentMethodRefCompletableFuture =
                CompletableFuture.<PaymentMethodRef>supplyAsync(() -> {
                    Optional<PaymentMethodRef> paymentMethodRefOptional =
                        partyAccountService.getPaymentMethodRefById(partyAccount.getDefaultPaymentMethod().getId());
                    if(paymentMethodRefOptional.isPresent()){
                        return paymentMethodRefOptional.get();
                    }
                    return null;
                });
        Mono<PaymentMethodRef> paymentMethodRefMono = Mono.fromFuture(paymentMethodRefCompletableFuture);

        CompletableFuture<List<RelatedPartyRef>> listOfRelatedPartyCompletableFuture =
                retrieveRelatedPartyRefs(partyAccount.getRelatedParty());
        Mono<List<RelatedPartyRef>> relatedPartyRefMono = Mono.fromFuture(listOfRelatedPartyCompletableFuture);

        CompletableFuture<List<AccountTaxExemption>> listOfAccountTaxListCompletableFuture =
                retrieveAccountTaxExceptions(partyAccount.getTaxExemption());
        Mono<List<AccountTaxExemption>> accountTaxExemptionMono = Mono.fromFuture(listOfAccountTaxListCompletableFuture);

        CompletableFuture<List<Contact>>  listOfContactCompletableFuture = retrieveContacts(partyAccount.getContact());
        Mono<List<Contact>> contactMono = Mono.fromFuture(listOfContactCompletableFuture);

        CompletableFuture<List<AccountBalance>> listCompletableFuture =
                retrieveAccountBalances(partyAccount.getAccountBalance());
        Mono<List<AccountBalance>> accountBalanceMono = Mono.fromFuture(listCompletableFuture);

        CompletableFuture<List<AccountRelationship>>  listOfAccCompletableFuture =
                retrieveAccountRelationships(partyAccount.getAccountRelationship());
        Mono<List<AccountRelationship>> accountRelationshipMono = Mono.fromFuture(listOfAccCompletableFuture);


        PartyAccount finalMonoPartyAccount = Mono.zip(Arrays.asList(
                        billStListMono ,financialAccountRefMono, listOfPaymentPlanMono,
                        paymentMethodRefMono, relatedPartyRefMono, accountTaxExemptionMono,
                        contactMono, accountBalanceMono, accountRelationshipMono), monos -> {

                    List<BillStructure> listOfBillStructures = (List<BillStructure>)monos[0] ;
                    partyAccount.setBillStructure(listOfBillStructures.get(0));

                    FinancialAccountRef financialAccountRef = (FinancialAccountRef)monos[1] ;
                    partyAccount.setFinancialAccount(financialAccountRef);

                    List<PaymentPlan> listOfPaymentPlans = (List<PaymentPlan>)monos[2] ;
                    partyAccount.setPaymentPlan(listOfPaymentPlans);

                    PaymentMethodRef paymentMethodRef = (PaymentMethodRef)monos[3] ;
                    partyAccount.setDefaultPaymentMethod(paymentMethodRef);

                    List<RelatedPartyRef> listOfRelatedPartyRefList = (List<RelatedPartyRef>)monos[4] ;
                    partyAccount.setRelatedParty(listOfRelatedPartyRefList);

                    List<AccountTaxExemption> listOfAccountTaxExemptionList = (List<AccountTaxExemption>)monos[5] ;
                    partyAccount.setTaxExemption(listOfAccountTaxExemptionList);

                    List<Contact> listOfContactList = (List<Contact>)monos[6] ;
                    partyAccount.setContact(listOfContactList);

                    List<AccountBalance> listOfAccountBalanceList = (List<AccountBalance>)monos[7] ;
                    partyAccount.setAccountBalance(listOfAccountBalanceList);

                    List<AccountRelationship> listOfAccountRelationshipList = (List<AccountRelationship>)monos[8] ;
                    partyAccount.setAccountRelationship(listOfAccountRelationshipList);

                    return partyAccount;
                } ).block();
        return finalMonoPartyAccount;
    }


    public BillingAccount populateBillingAccount(BillingAccount billingAccount){

        CompletableFuture<List<BillStructure>> listOfBillListCompletableFuture =
                retrieveBillStructures(billingAccount.getBillStructure());
        Mono<List<BillStructure>> billStListMono = Mono.fromFuture(listOfBillListCompletableFuture);

        CompletableFuture<FinancialAccountRef> financialAccountRefCompletableFuture =
                CompletableFuture.<FinancialAccountRef>supplyAsync(
                        () -> {
                            Optional<FinancialAccountRef> financialAccountRefOptional =
                                    partyAccountService.getFinancialAccountRefById(billingAccount.getFinancialAccount().getId());
                            if(financialAccountRefOptional.isPresent()){
                                return  financialAccountRefOptional.get();
                            }
                            return null;
                        }
                );
        Mono<FinancialAccountRef> financialAccountRefMono = Mono.fromFuture(financialAccountRefCompletableFuture);

        CompletableFuture<List<PaymentPlan>> listOfPaymentListCompletableFuture =
                CompletableFuture.<List<PaymentPlan>>supplyAsync(() -> {
                    List<PaymentPlan> finalListPaymentPlans = new ArrayList<>();
                    billingAccount.getPaymentPlan().stream()
                            .forEach(
                                    element -> {
                                        Optional<PaymentPlan> optionalPaymentPlan =
                                                partyAccountService.getPaymentPlanById(element.getId());
                                        if(optionalPaymentPlan.isPresent()){
                                            finalListPaymentPlans.add(optionalPaymentPlan.get());
                                        }
                                    }
                            );
                    return finalListPaymentPlans;
                });
        Mono<List<PaymentPlan>> listOfPaymentPlanMono = Mono.fromFuture(listOfPaymentListCompletableFuture);

        CompletableFuture<PaymentMethodRef> paymentMethodRefCompletableFuture =
                CompletableFuture.<PaymentMethodRef>supplyAsync(() -> {
                    Optional<PaymentMethodRef> paymentMethodRefOptional =
                            partyAccountService.getPaymentMethodRefById(billingAccount.getDefaultPaymentMethod().getId());
                    if(paymentMethodRefOptional.isPresent()){
                        return paymentMethodRefOptional.get();
                    }
                    return null;
                });
        Mono<PaymentMethodRef> paymentMethodRefMono = Mono.fromFuture(paymentMethodRefCompletableFuture);

        CompletableFuture<List<RelatedPartyRef>> listOfRelatedPartyCompletableFuture =
                retrieveRelatedPartyRefs(billingAccount.getRelatedParty());
        Mono<List<RelatedPartyRef>> relatedPartyRefMono = Mono.fromFuture(listOfRelatedPartyCompletableFuture);

        CompletableFuture<List<AccountTaxExemption>> listOfAccountTaxListCompletableFuture =
                retrieveAccountTaxExceptions(billingAccount.getTaxExemption());
        Mono<List<AccountTaxExemption>> accountTaxExemptionMono = Mono.fromFuture(listOfAccountTaxListCompletableFuture);

        CompletableFuture<List<Contact>>  listOfContactCompletableFuture = retrieveContacts(billingAccount.getContact());
        Mono<List<Contact>> contactMono = Mono.fromFuture(listOfContactCompletableFuture);

        CompletableFuture<List<AccountBalance>> listCompletableFuture =
                retrieveAccountBalances(billingAccount.getAccountBalance());
        Mono<List<AccountBalance>> accountBalanceMono = Mono.fromFuture(listCompletableFuture);

        CompletableFuture<List<AccountRelationship>>  listOfAccCompletableFuture =
                retrieveAccountRelationships(billingAccount.getAccountRelationship());
        Mono<List<AccountRelationship>> accountRelationshipMono = Mono.fromFuture(listOfAccCompletableFuture);


        BillingAccount finalMonoBillingAccount = Mono.zip(Arrays.asList(
                billStListMono ,financialAccountRefMono, listOfPaymentPlanMono,
                paymentMethodRefMono, relatedPartyRefMono, accountTaxExemptionMono,
                contactMono, accountBalanceMono, accountRelationshipMono), monos -> {

            List<BillStructure> listOfBillStructures = (List<BillStructure>)monos[0] ;
            billingAccount.setBillStructure(listOfBillStructures.get(0));

            FinancialAccountRef financialAccountRef = (FinancialAccountRef)monos[1] ;
            billingAccount.setFinancialAccount(financialAccountRef);

            List<PaymentPlan> listOfPaymentPlans = (List<PaymentPlan>)monos[2] ;
            billingAccount.setPaymentPlan(listOfPaymentPlans);

            PaymentMethodRef paymentMethodRef = (PaymentMethodRef)monos[3] ;
            billingAccount.setDefaultPaymentMethod(paymentMethodRef);

            List<RelatedPartyRef> listOfRelatedPartyRefList = (List<RelatedPartyRef>)monos[4] ;
            billingAccount.setRelatedParty(listOfRelatedPartyRefList);

            List<AccountTaxExemption> listOfAccountTaxExemptionList = (List<AccountTaxExemption>)monos[5] ;
            billingAccount.setTaxExemption(listOfAccountTaxExemptionList);

            List<Contact> listOfContactList = (List<Contact>)monos[6] ;
            billingAccount.setContact(listOfContactList);

            List<AccountBalance> listOfAccountBalanceList = (List<AccountBalance>)monos[7] ;
            billingAccount.setAccountBalance(listOfAccountBalanceList);

            List<AccountRelationship> listOfAccountRelationshipList = (List<AccountRelationship>)monos[8] ;
            billingAccount.setAccountRelationship(listOfAccountRelationshipList);

            return billingAccount;
        } ).block();
        return finalMonoBillingAccount;
    }


    public SettlementAccount populateSettlementAccount(SettlementAccount settlementAccount){

        CompletableFuture<List<BillStructure>> listOfBillListCompletableFuture =
                retrieveBillStructures(settlementAccount.getBillStructure());
        Mono<List<BillStructure>> billStListMono = Mono.fromFuture(listOfBillListCompletableFuture);

        CompletableFuture<FinancialAccountRef> financialAccountRefCompletableFuture =
                CompletableFuture.<FinancialAccountRef>supplyAsync(
                        () -> {
                            Optional<FinancialAccountRef> financialAccountRefOptional =
                                    partyAccountService.getFinancialAccountRefById(settlementAccount.getFinancialAccount().getId());
                            if(financialAccountRefOptional.isPresent()){
                                return  financialAccountRefOptional.get();
                            }
                            return null;
                        }
                );
        Mono<FinancialAccountRef> financialAccountRefMono = Mono.fromFuture(financialAccountRefCompletableFuture);

        CompletableFuture<List<PaymentPlan>> listOfPaymentListCompletableFuture =
                CompletableFuture.<List<PaymentPlan>>supplyAsync(() -> {
                    List<PaymentPlan> finalListPaymentPlans = new ArrayList<>();
                    settlementAccount.getPaymentPlan().stream()
                            .forEach(
                                    element -> {
                                        Optional<PaymentPlan> optionalPaymentPlan =
                                                partyAccountService.getPaymentPlanById(element.getId());
                                        if(optionalPaymentPlan.isPresent()){
                                            finalListPaymentPlans.add(optionalPaymentPlan.get());
                                        }
                                    }
                            );
                    return finalListPaymentPlans;
                });
        Mono<List<PaymentPlan>> listOfPaymentPlanMono = Mono.fromFuture(listOfPaymentListCompletableFuture);

        CompletableFuture<PaymentMethodRef> paymentMethodRefCompletableFuture =
                CompletableFuture.<PaymentMethodRef>supplyAsync(() -> {
                    Optional<PaymentMethodRef> paymentMethodRefOptional =
                            partyAccountService.getPaymentMethodRefById(settlementAccount.getDefaultPaymentMethod().getId());
                    if(paymentMethodRefOptional.isPresent()){
                        return paymentMethodRefOptional.get();
                    }
                    return null;
                });
        Mono<PaymentMethodRef> paymentMethodRefMono = Mono.fromFuture(paymentMethodRefCompletableFuture);

        CompletableFuture<List<RelatedPartyRef>> listOfRelatedPartyCompletableFuture =
                retrieveRelatedPartyRefs(settlementAccount.getRelatedParty());
        Mono<List<RelatedPartyRef>> relatedPartyRefMono = Mono.fromFuture(listOfRelatedPartyCompletableFuture);

        CompletableFuture<List<AccountTaxExemption>> listOfAccountTaxListCompletableFuture =
                retrieveAccountTaxExceptions(settlementAccount.getTaxExemption());
        Mono<List<AccountTaxExemption>> accountTaxExemptionMono = Mono.fromFuture(listOfAccountTaxListCompletableFuture);

        CompletableFuture<List<Contact>>  listOfContactCompletableFuture = retrieveContacts(settlementAccount.getContact());
        Mono<List<Contact>> contactMono = Mono.fromFuture(listOfContactCompletableFuture);

        CompletableFuture<List<AccountBalance>> listCompletableFuture =
                retrieveAccountBalances(settlementAccount.getAccountBalance());
        Mono<List<AccountBalance>> accountBalanceMono = Mono.fromFuture(listCompletableFuture);

        CompletableFuture<List<AccountRelationship>>  listOfAccCompletableFuture =
                retrieveAccountRelationships(settlementAccount.getAccountRelationship());
        Mono<List<AccountRelationship>> accountRelationshipMono = Mono.fromFuture(listOfAccCompletableFuture);


        SettlementAccount finalMonoSettlementAccount = Mono.zip(Arrays.asList(
                billStListMono ,financialAccountRefMono, listOfPaymentPlanMono,
                paymentMethodRefMono, relatedPartyRefMono, accountTaxExemptionMono,
                contactMono, accountBalanceMono, accountRelationshipMono), monos -> {

            List<BillStructure> listOfBillStructures = (List<BillStructure>)monos[0] ;
            settlementAccount.setBillStructure(listOfBillStructures.get(0));

            FinancialAccountRef financialAccountRef = (FinancialAccountRef)monos[1] ;
            settlementAccount.setFinancialAccount(financialAccountRef);

            List<PaymentPlan> listOfPaymentPlans = (List<PaymentPlan>)monos[2] ;
            settlementAccount.setPaymentPlan(listOfPaymentPlans);

            PaymentMethodRef paymentMethodRef = (PaymentMethodRef)monos[3] ;
            settlementAccount.setDefaultPaymentMethod(paymentMethodRef);

            List<RelatedPartyRef> listOfRelatedPartyRefList = (List<RelatedPartyRef>)monos[4] ;
            settlementAccount.setRelatedParty(listOfRelatedPartyRefList);

            List<AccountTaxExemption> listOfAccountTaxExemptionList = (List<AccountTaxExemption>)monos[5] ;
            settlementAccount.setTaxExemption(listOfAccountTaxExemptionList);

            List<Contact> listOfContactList = (List<Contact>)monos[6] ;
            settlementAccount.setContact(listOfContactList);

            List<AccountBalance> listOfAccountBalanceList = (List<AccountBalance>)monos[7] ;
            settlementAccount.setAccountBalance(listOfAccountBalanceList);

            List<AccountRelationship> listOfAccountRelationshipList = (List<AccountRelationship>)monos[8] ;
            settlementAccount.setAccountRelationship(listOfAccountRelationshipList);

            return settlementAccount;
        } ).block();
        return finalMonoSettlementAccount;
    }
}
