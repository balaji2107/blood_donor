package com.example.blooddonor.mapper;

import com.example.blooddonor.dto.CredentialDTO;
import com.example.blooddonor.dto.UserDTO;
import com.example.blooddonor.model.Credential;
import com.example.blooddonor.model.User;

public class UserMapper {
	
	 public static UserDTO toDto(User user) {  
	        return UserDTO.builder()
	                .username(user.getUsername())
	                .email(user.getEmail())
					.mobileNo(user.getMobileNo())
					.credential(user.getCredential())
	                .build();
	    }

	    public static User toEntity(UserDTO userDTO) {
	        return User.builder()
	                .username(userDTO.getUsername())
	                .email(userDTO.getEmail())
					.mobileNo(userDTO.getMobileNo())
					.credential(userDTO.getCredential())
	                .build();
	    }


	public static Credential toCred(CredentialDTO credentialDTO) {
		return Credential.builder()
				.email(credentialDTO.getEmail())
				.role(credentialDTO.getRole())
				.user(credentialDTO.getUser())
				.password(credentialDTO.getPassword())
				.build();
	}
}
