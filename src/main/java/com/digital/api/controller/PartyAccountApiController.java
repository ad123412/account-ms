package com.digital.api.controller;

import com.digital.api.model.PartyAccount;
import com.digital.api.model.PartyAccountCreate;
import com.digital.api.model.PartyAccountUpdate;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class PartyAccountApiController {

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
    public ResponseEntity<List<PartyAccount>> listPartyAccount(@ApiParam(value = "Comma separated properties to display in response") @RequestParam(value = "fields", required = false) String fields
        ,@ApiParam(value = "Requested index for start of resources to be provided in response") @RequestParam(value = "offset", required = false) Integer offset
        ,@ApiParam(value = "Requested number of resources to be provided in response") @RequestParam(value = "limit", required = false) Integer limit
    ) {
        // do some magic!
        return new ResponseEntity<List<PartyAccount>>(HttpStatus.OK);
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
    public ResponseEntity<List<PartyAccount>> retrievePartyAccount(
@ApiParam(value = "Identifier of the Party Account",required=true ) @PathVariable("id") String id


) {
        // do some magic!
        return new ResponseEntity<List<PartyAccount>>(HttpStatus.OK);
    }

}
