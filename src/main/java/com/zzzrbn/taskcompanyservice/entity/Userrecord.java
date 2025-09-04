package com.zzzrbn.taskcompanyservice.entity;

import java.util.Objects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Userrecord{
	
    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private Long companyId;
    
	@Override
	public int hashCode() {
		return Objects.hash(companyId, firstname, lastname, phoneNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Userrecord other = (Userrecord) obj;
		return Objects.equals(companyId, other.companyId) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(phoneNumber, other.phoneNumber);
	}  
    
    
}
