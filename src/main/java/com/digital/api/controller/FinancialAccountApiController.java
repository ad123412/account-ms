package com.digital.api.controller;

import com.digital.api.model.AccountTaxExemption;
import com.digital.api.model.FinancialAccount;
import com.digital.api.model.FinancialAccountCreate;
import com.digital.api.model.FinancialAccountUpdate;

import com.digital.api.service.FinancialAccountServiceImpl;
import com.digital.api.util.FinancialAccountUtil;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class FinancialAccountApiController {

    @Autowired
    private FinancialAccountServiceImpl financialAccountService;

    @Autowired
    private FinancialAccountUtil financialAccountUtil;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = FinancialAccount.class),
            @ApiResponse(code = 400, message = "Bad Request", response = FinancialAccount.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = FinancialAccount.class),
            @ApiResponse(code = 403, message = "Forbidden", response = FinancialAccount.class),
            @ApiResponse(code = 404, message = "Not Found", response = FinancialAccount.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = FinancialAccount.class),
            @ApiResponse(code = 409, message = "Conflict", response = FinancialAccount.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = FinancialAccount.class) })
    @GetMapping(value = "/financialAccount", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<FinancialAccount> listFinancialAccount(@ApiParam(value = "Comma separated properties to display in response") @RequestParam(value = "fields", required = false) String fields
        ,@ApiParam(value = "Requested index for start of resources to be provided in response") @RequestParam(value = "offset", required = false) Integer offset
        ,@ApiParam(value = "Requested number of resources to be provided in response") @RequestParam(value = "limit", required = false) Integer limit
    ) {

        List<FinancialAccount> financialAccountList = new ArrayList<>();
        financialAccountService.getAllFinancialAccount().stream()
            .forEach(
                    financialAccount -> {
                        try {
                            financialAccountList.add(financialAccountUtil.populateFinancialAccount(financialAccount));
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
        return Flux.fromIterable(financialAccountList);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = FinancialAccount.class),
            @ApiResponse(code = 400, message = "Bad Request", response = FinancialAccount.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = FinancialAccount.class),
            @ApiResponse(code = 403, message = "Forbidden", response = FinancialAccount.class),
            @ApiResponse(code = 404, message = "Not Found", response = FinancialAccount.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = FinancialAccount.class),
            @ApiResponse(code = 409, message = "Conflict", response = FinancialAccount.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = FinancialAccount.class) })
    @GetMapping(value = "/financialAccount/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<FinancialAccount> retrieveFinancialAccount(
        @ApiParam(value = "Identifier of the Financial Account",required=true ) @PathVariable("id") String id
    ) throws ExecutionException, InterruptedException {

        Optional<FinancialAccount> financialAccountOptional =
                financialAccountService.getFinancialAccountById(id);
        if(financialAccountOptional.isPresent()){
            FinancialAccount financialAccount =
                    financialAccountUtil.populateFinancialAccount(financialAccountOptional.get());
            return Flux.just(financialAccount);
        }
        return Flux.empty();
    }

    @GetMapping(value = "/taxExcemption/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<AccountTaxExemption> retrieveAccountTaxExemption(@PathVariable("id") String id){

        Optional<AccountTaxExemption> accountTaxExemptionOp = financialAccountService.getAccountTaxExemptionById(id);
        if(accountTaxExemptionOp.isPresent())
            return Flux.just(accountTaxExemptionOp.get());
        return Flux.empty();
    }

}
