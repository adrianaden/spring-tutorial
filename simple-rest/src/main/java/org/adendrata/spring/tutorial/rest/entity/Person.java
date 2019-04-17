package org.adendrata.spring.tutorial.rest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "fist_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty(required = true)
    @Column(name = "gender")
    private GenderType gender;

    public Person() {
    }

    public Person(String firstName, String lastName, GenderType gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }


    public enum GenderType {
        MALE, FEMALE
    }
}
