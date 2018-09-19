package com.digital.api.controller;

import com.digital.api.model.PartyAccount;
import com.digital.api.model.PartyAccountCreate;
import com.digital.api.model.PartyAccountUpdate;

import com.digital.api.service.FinancialAccountServiceImpl;
import com.digital.api.service.PartyAccountServiceImpl;
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

@RestController
public class PartyAccountApiController {

    @Autowired
    private PartyAccountServiceImpl partyAccountService;

    @Autowired
    private FinancialAccountServiceImpl financialAccountService;

    @Autowired
    private FinancialAccountUtil financialAccountUtil;

    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok", response = PartyAccount.class),
    @ApiResponse(code = 400, message = "Bad Request", response = PartyAccount.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = PartyAccount.class),
    @ApiResponse(code = 403, message = "Forbidden", response = PartyAccount.class),
    @ApiResponse(code = 404, message = "Not Found", response = PartyAccount.class),
    @ApiResponse(code = 405, message = "Method Not allowed", response = PartyAccount.class),
    @ApiResponse(code = 409, message = "Conflict", response = PartyAccount.class),
    @ApiResponse(code = 500, message = "Internal Server Error", response = PartyAccount.class) })
    @GetMapping(value = "/partyAccount", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<PartyAccount> listPartyAccount(@ApiParam(value = "Comma separated properties to display in response") @RequestParam(value = "fields", required = false) String fields
        , @ApiParam(value = "Requested index for start of resources to be provided in response") @RequestParam(value = "offset", required = false) Integer offset
        , @ApiParam(value = "Requested number of resources to be provided in response") @RequestParam(value = "limit", required = false) Integer limit
    ) {

        List<PartyAccount> finalPartyAccountList = new ArrayList<>();
        partyAccountService.getAllPartyAccounts().stream()
                .forEach(partyAccount -> {
                    finalPartyAccountList.add(financialAccountUtil.populatePartyAccount(partyAccount));
                });
        return Flux.fromIterable(finalPartyAccountList);
    }


    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Ok", response = PartyAccount.class),
    @ApiResponse(code = 400, message = "Bad Request", response = PartyAccount.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = PartyAccount.class),
    @ApiResponse(code = 403, message = "Forbidden", response = PartyAccount.class),
    @ApiResponse(code = 404, message = "Not Found", response = PartyAccount.class),
    @ApiResponse(code = 405, message = "Method Not allowed", response = PartyAccount.class),
    @ApiResponse(code = 409, message = "Conflict", response = PartyAccount.class),
    @ApiResponse(code = 500, message = "Internal Server Error", response = PartyAccount.class) })
    @GetMapping(value = "/partyAccount/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<PartyAccount> retrievePartyAccount(
        @ApiParam(value = "Identifier of the Party Account",required=true ) @PathVariable("id") String id
    ) {

        Optional<PartyAccount> partyAccountOptional =
                partyAccountService.getPartyAccountById(id);
        if(partyAccountOptional.isPresent()){
            PartyAccount partyAccount =
                    financialAccountUtil.populatePartyAccount(partyAccountOptional.get());
            return Flux.just(partyAccount);
        }
        return Flux.empty();
    }

}
