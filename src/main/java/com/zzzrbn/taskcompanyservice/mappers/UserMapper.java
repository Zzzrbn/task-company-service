package com.zzzrbn.taskcompanyservice.mappers;

import org.springframework.stereotype.Component;

import com.zzzrbn.taskcompanyservice.entity.Company;
import com.zzzrbn.taskcompanyservice.entity.UserDTO;
import com.zzzrbn.taskcompanyservice.entity.Userrecord;

@Component
public class UserMapper {

	public UserDTO toDTO(Userrecord userrecord, Company company) {
        if (userrecord == null) {
            return null;
        }
        
        UserDTO dto = new UserDTO();
        dto.setId(userrecord.getId());
        dto.setFirstname(userrecord.getFirstname());
        dto.setLastname(userrecord.getFirstname());
        dto.setPhoneNumber(userrecord.getPhoneNumber());
        dto.setCompany(company);
        dto.setCompanyId(userrecord.getCompanyId());
        return dto;
    }

    public Userrecord toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        
        Userrecord userrecord = new Userrecord();
        userrecord.setId(userDTO.getId());
        userrecord.setFirstname(userDTO.getFirstname());
        userrecord.setLastname(userDTO.getFirstname());
        userrecord.setPhoneNumber(userDTO.getPhoneNumber());
        
        if (userDTO.getCompany() != null) {
            userrecord.setCompanyId(userDTO.getCompany().getId()
            		);
        }
//        if (userDTO.getCompanyId()!=null)
//        {
        	userrecord.setCompanyId(userDTO.getCompanyId());
//        }
        
        return userrecord;
    }
}
