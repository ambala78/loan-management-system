package com.mybank.lms.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class LmsUser implements Serializable {
    @Id
    private String lmsUsername;
    private String lmsUserpass;
    private String lmsUserrole;

    public LmsUser(LmsUser lmsUser) {
        this.lmsUsername = lmsUser.lmsUsername;
        this.lmsUserpass = lmsUser.lmsUserpass;
        this.lmsUserrole = lmsUser.lmsUserrole;
    }
}
