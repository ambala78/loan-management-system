package com.mybank.lms.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private String statusCode;
    private String statusDescription;
}
