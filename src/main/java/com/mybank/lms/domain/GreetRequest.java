package com.mybank.lms.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "greetRequestSequence", sequenceName = "GreetRequest_SEQ")
public class GreetRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "greetRequestSequence")
    private String name;
    private String jobAbbr;
}
