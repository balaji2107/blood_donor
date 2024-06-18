package com.example.blooddonor.mapper;

import com.example.blooddonor.dto.EligibleDTO;
import com.example.blooddonor.dto.UserDTO;
import com.example.blooddonor.model.Credential;
import com.example.blooddonor.model.Eligible;
import com.example.blooddonor.model.User;

import java.util.Optional;

public class UserMapper {
	
	 public static UserDTO toDto(User user) {  
	        return UserDTO.builder()
	                .username(user.getUsername())
					.mobileNo(user.getMobileNo())
					.bloodGroup(user.getBloodGroup())
					.country(user.getCountry())
					.statedrpdwn(user.getStatedrpdwn())
					.districtdrpdwn(user.getDistrictdrpdwn())
					.citydrpdwn(user.getCitydrpdwn())
	                .build();
	    }

	    public static User toEntity(UserDTO userDTO) {
			return User.builder()
					.username(userDTO.getUsername())
					.mobileNo(userDTO.getMobileNo())
					.bloodGroup(userDTO.getBloodGroup())
					.country(userDTO.getCountry())
					.statedrpdwn(userDTO.getStatedrpdwn())
					.districtdrpdwn(userDTO.getDistrictdrpdwn())
					.citydrpdwn(userDTO.getCitydrpdwn())
					.build();
	    }


	public static Credential toCred(UserDTO userDTO,User user) {
		return Credential.builder()
				.email(userDTO.getEmail())
				.password(userDTO.getPassword())
//				.role(userDTO.getRole())
				.user(user)
				.build();
	}

	public static Eligible toEligible(EligibleDTO eligibleDTO, User user) {
		 return Eligible.builder()
				 .isWeight(eligibleDTO.getIsWeight())
				 .isTransmittableDisease(eligibleDTO.getIsTransmittableDisease())
				 .disease(eligibleDTO.getDisease())
				 .isAsthama(eligibleDTO.getIsAsthama())
				 .user(user)
				 .build();
	}
}
