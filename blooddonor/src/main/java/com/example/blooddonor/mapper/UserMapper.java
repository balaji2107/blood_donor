package com.example.blooddonor.mapper;

import com.example.blooddonor.dto.CredentialDTO;
import com.example.blooddonor.dto.UserDTO;
import com.example.blooddonor.model.Credential;
import com.example.blooddonor.model.User;

public class UserMapper {
	
	 public static UserDTO toDto(User user) {  
	        return UserDTO.builder()
	                .username(user.getUsername())
					.mobileNo(user.getMobileNo())
	                .build();
	    }

	    public static User toEntity(UserDTO userDTO) {
			return User.builder()
					.username(userDTO.getUsername())
					.mobileNo(userDTO.getMobileNo())
					.build();
	    }


	public static Credential toCred(UserDTO userDTO,User user) {
		return Credential.builder()
				.email(userDTO.getEmail())
				.password(userDTO.getPassword())
				.role(userDTO.getRole())
				.user(user)
				.build();
	}
}
