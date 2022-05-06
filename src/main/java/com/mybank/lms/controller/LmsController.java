package com.mybank.lms.controller;

import com.mybank.lms.domain.GreetRequest;
import com.mybank.lms.domain.GreetResponse;
import com.mybank.lms.domain.LmsUser;
import com.mybank.lms.service.ExpansionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lms/v1")
public class LmsController {

    @Autowired
    private ExpansionService expansionService;

    @PostMapping(path = "/greetMe",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public GreetResponse helloWorld(@RequestBody GreetRequest greetRequest, @AuthenticationPrincipal LmsUser lmsUser) {
        return expansionService.expand(greetRequest);
    }
}
