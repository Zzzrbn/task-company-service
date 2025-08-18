package com.zzzrbn.taskcompanyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzzrbn.taskcompanyservice.dao.UserrecordDAO;
import com.zzzrbn.taskcompanyservice.entity.UserDTO;
import com.zzzrbn.taskcompanyservice.entity.Userrecord;

import jakarta.transaction.Transactional;

//@Service
public class UserrecordServiceImpl implements UserrecordService{
	
//	@Autowired
//	private UserrecordDAO userrecordDAO;
//
//	@Override
//	@Transactional
//	public List<UserDTO> getAllUsersrecords() {
//		return userrecordDAO.getAllUsersrecords();
//	}
//
//	@Override
//	@Transactional
//	public void createUserrecord(UserDTO userDTO) {
//		userrecordDAO.createUserrecord(userDTO);
//		
//	}
//
//	@Override
//	@Transactional
//	public UserDTO getUserrecord(Long id) {
//		return userrecordDAO.getUserrecord(id);
//	}
//
//	@Override
//	@Transactional
//	public void deleteUserrecord(Long id)  throws Exception {
//		userrecordDAO.deleteUserrecord(id);
//		
//	}
//
//	@Override
//	@Transactional
//	public void updateUserrecord(Long id, UserDTO userDTO) {
//		userrecordDAO.updateUserrecord(id, userDTO);
//		
//	}
//
//	@Override
//	public List<Userrecord> getUserrecordsbyId(Long id) {
//		return userrecordDAO.getUserrecordsbyId(id);
//	}
//	
//	

}
