package com.zzzrbn.taskcompanyservice.entity;

import lombok.Data;

@Data
public class Userrecord{	
    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private Long companyId;  
}
