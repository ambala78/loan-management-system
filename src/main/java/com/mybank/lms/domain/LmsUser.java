package com.mybank.lms.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Data
@Entity
public class LmsUser implements Serializable {
    @Id
    private String username;
    private String userpass;
    private String userrole;
}
