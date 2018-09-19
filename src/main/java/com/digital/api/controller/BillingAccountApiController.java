package com.digital.api.controller;

import com.digital.api.model.BillingAccount;
import com.digital.api.service.PartyAccountServiceImpl;
import com.digital.api.util.FinancialAccountUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BillingAccountApiController {

    @Autowired
    private PartyAccountServiceImpl partyAccountService;

    @Autowired
    private FinancialAccountUtil financialAccountUtil;

    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok", response = BillingAccount.class),
    @ApiResponse(code = 400, message = "Bad Request", response = BillingAccount.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = BillingAccount.class),
    @ApiResponse(code = 403, message = "Forbidden", response = BillingAccount.class),
    @ApiResponse(code = 404, message = "Not Found", response = BillingAccount.class),
    @ApiResponse(code = 405, message = "Method Not allowed", response = BillingAccount.class),
    @ApiResponse(code = 409, message = "Conflict", response = BillingAccount.class),
    @ApiResponse(code = 500, message = "Internal Server Error", response = BillingAccount.class)})
    @GetMapping(value = "/billingAccount", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<BillingAccount> listBillingAccount(@ApiParam(value = "Comma separated properties to display in response") @RequestParam(value = "fields", required = false) String fields
            , @ApiParam(value = "Requested index for start of resources to be provided in response") @RequestParam(value = "offset", required = false) Integer offset
            , @ApiParam(value = "Requested number of resources to be provided in response") @RequestParam(value = "limit", required = false) Integer limit
    ) {

        List<BillingAccount> finalBillingAccountList = new ArrayList<>();
        partyAccountService.getAllBillingAccounts().stream()
                .forEach(billingAccount -> {
                    finalBillingAccountList.add(financialAccountUtil.populateBillingAccount(billingAccount));
                });
        return Flux.fromIterable(finalBillingAccountList);
    }


    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok", response = BillingAccount.class),
    @ApiResponse(code = 400, message = "Bad Request", response = BillingAccount.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = BillingAccount.class),
    @ApiResponse(code = 403, message = "Forbidden", response = BillingAccount.class),
    @ApiResponse(code = 404, message = "Not Found", response = BillingAccount.class),
    @ApiResponse(code = 405, message = "Method Not allowed", response = BillingAccount.class),
    @ApiResponse(code = 409, message = "Conflict", response = BillingAccount.class),
    @ApiResponse(code = 500, message = "Internal Server Error", response = BillingAccount.class)})
    @GetMapping(value = "/billingAccount/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<BillingAccount> retrieveBillingAccount(
            @ApiParam(value = "Identifier of the Billing Account", required = true) @PathVariable("id") String id) {

        Optional<BillingAccount> billingAccountOptional =
                partyAccountService.getBillingAccountById(id);
        if (billingAccountOptional.isPresent()) {
            BillingAccount billingAccount =
                    financialAccountUtil.populateBillingAccount(billingAccountOptional.get());
            return Flux.just(billingAccount);
        }
        return Flux.empty();
    }

}