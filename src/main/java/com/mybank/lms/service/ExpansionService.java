package com.mybank.lms.service;

import com.mybank.lms.domain.GreetRequest;
import com.mybank.lms.domain.GreetResponse;
import org.springframework.stereotype.Service;

@Service
public class ExpansionService {
    public GreetResponse expand(GreetRequest abbr) {
        return GreetResponse.builder()
        .helloName("Hello ".concat(abbr.getName()))
        .jobExpansion(expandJob(abbr.getJobAbbr()))
        .build();
        
    }

    private String expandJob(String abbr) {
        if ("SE".equals(abbr)) {
            return "Software Engineer";
        } else if ("PA".equals(abbr)) {
            return "Product Analyst";
        }
        return "Not Available for ".concat(abbr);
    }
}
