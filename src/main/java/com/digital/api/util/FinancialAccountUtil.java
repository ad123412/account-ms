package com.digital.api.util;

import com.digital.api.model.*;
import com.digital.api.service.FinancialAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
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

    public FinancialAccount populateFinancialAccount(FinancialAccount financialAccount) throws ExecutionException, InterruptedException {

        CompletableFuture<List<RelatedPartyRef>> listOfRelatedPartyCompletableFuture =
                CompletableFuture.<List<RelatedPartyRef>>supplyAsync(
                () -> {
                    List<RelatedPartyRef> relatedPartyRefList = financialAccount.getRelatedParty();
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
        Mono<List<RelatedPartyRef>> relatedPartyRefMono = Mono.fromFuture(listOfRelatedPartyCompletableFuture);


        CompletableFuture<List<AccountTaxExemption>> listOfAccountTaxListCompletableFuture =
                CompletableFuture.<List<AccountTaxExemption>>supplyAsync(
                        () -> {
                            List<AccountTaxExemption> accountTaxExemptionList = financialAccount.getTaxExemption();
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
        Mono<List<AccountTaxExemption>> accountTaxExemptionMono = Mono.fromFuture(listOfAccountTaxListCompletableFuture);

        CompletableFuture<List<Contact>>  listOfContactCompletableFuture = CompletableFuture.<List<Contact>>supplyAsync(

                () -> {
                    List<Contact> contacts = new ArrayList<>();
                    financialAccount.getContact().stream()
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
        Mono<List<Contact>> contactMono = Mono.fromFuture(listOfContactCompletableFuture);

        CompletableFuture<List<AccountBalance>> listCompletableFuture = CompletableFuture.<List<AccountBalance>>supplyAsync(() -> {

            List<AccountBalance> accountBalanceList = new ArrayList<>();
            financialAccount.getAccountBalance().stream()
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
        Mono<List<AccountBalance>> accountBalanceMono = Mono.fromFuture(listCompletableFuture);

        CompletableFuture<List<AccountRelationship>>  listOfAccCompletableFuture = CompletableFuture.supplyAsync(() -> {
            List<AccountRelationship> accountRelationships = new ArrayList<>();
            financialAccount.getAccountRelationship().stream()
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
}
