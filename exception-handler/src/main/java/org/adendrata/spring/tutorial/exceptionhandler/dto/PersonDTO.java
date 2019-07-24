package org.adendrata.spring.tutorial.exceptionhandler.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class PersonDTO {
    @NotNull
    private String firstName;
    private String lastName;

    @NotNull
    private Long height;
}
