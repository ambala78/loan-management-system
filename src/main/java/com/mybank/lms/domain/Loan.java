package com.mybank.lms.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Data
@Entity
@SequenceGenerator(name = "loanSequence", sequenceName = "loan_seq", initialValue = 3000)
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "loanSequence")
    private Long loadId;
    private String number;
    private String amount;
    private String term;
    private String status;
    private String fee;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="propertyId_fk")
    private Property property;
}
