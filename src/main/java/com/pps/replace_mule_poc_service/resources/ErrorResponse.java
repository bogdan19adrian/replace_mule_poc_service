package com.pps.replace_mule_poc_service.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse implements Resource{
    private String errorCode;
    private String message;
}
