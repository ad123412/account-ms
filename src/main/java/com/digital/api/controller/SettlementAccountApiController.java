package com.digital.api.controller;

import com.digital.api.model.SettlementAccount;
import com.digital.api.model.SettlementAccountCreate;
import com.digital.api.model.SettlementAccountUpdate;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
public class SettlementAccountApiController{

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = SettlementAccount.class),
            @ApiResponse(code = 400, message = "Bad Request", response = SettlementAccount.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = SettlementAccount.class),
            @ApiResponse(code = 403, message = "Forbidden", response = SettlementAccount.class),
            @ApiResponse(code = 404, message = "Not Found", response = SettlementAccount.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = SettlementAccount.class),
            @ApiResponse(code = 409, message = "Conflict", response = SettlementAccount.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = SettlementAccount.class) })
    @GetMapping(value = "/settlementAccount", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<SettlementAccount>> listSettlementAccount(@ApiParam(value = "Comma separated properties to display in response") @RequestParam(value = "fields", required = false) String fields
        ,@ApiParam(value = "Requested index for start of resources to be provided in response") @RequestParam(value = "offset", required = false) Integer offset
            ,@ApiParam(value = "Requested number of resources to be provided in response") @RequestParam(value = "limit", required = false) Integer limit
    ) {



        return new ResponseEntity<List<SettlementAccount>>(HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = SettlementAccount.class),
            @ApiResponse(code = 400, message = "Bad Request", response = SettlementAccount.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = SettlementAccount.class),
            @ApiResponse(code = 403, message = "Forbidden", response = SettlementAccount.class),
            @ApiResponse(code = 404, message = "Not Found", response = SettlementAccount.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = SettlementAccount.class),
            @ApiResponse(code = 409, message = "Conflict", response = SettlementAccount.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = SettlementAccount.class) })
    @GetMapping(value = "/settlementAccount/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<SettlementAccount>> retrieveSettlementAccount(
        @ApiParam(value = "Identifier of the Settlement Account",required=true ) @PathVariable("id") String id
    ) {




        return new ResponseEntity<List<SettlementAccount>>(HttpStatus.OK);
    }

}
