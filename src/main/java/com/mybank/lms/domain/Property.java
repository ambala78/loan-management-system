package com.mybank.lms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Data
@Entity
@SequenceGenerator(name = "propertySequence", sequenceName = "property_seq", initialValue = 2000)
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "propertySequence")
    private Long propertyId;
    private String streetNumber;
    private String streetName;
    private String unitNumber;
    private String city;
    private String state;
    private String zip;
}
