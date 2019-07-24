package org.adendrata.spring.tutorial.exceptionhandler.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class ResponseFailure {
    private Long timestamp;
    private String result;
    private String message;
    private List<String> errors;
}
