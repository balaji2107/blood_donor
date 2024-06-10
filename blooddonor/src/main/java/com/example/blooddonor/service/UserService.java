package com.example.blooddonor.service;

import java.util.ArrayList;
import java.util.List;

import com.example.blooddonor.dto.CredentialDTO;
import com.example.blooddonor.model.Credential;
import com.example.blooddonor.repository.CredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blooddonor.dto.UserDTO;
import com.example.blooddonor.mapper.UserMapper;
import com.example.blooddonor.model.User;
import com.example.blooddonor.repository.UserRepo;

@Service
public class UserService implements IUserService{
	
	    @Autowired
	    private UserRepo userRepository;

		@Autowired
		private CredentialRepo credentialRepo;


	    @Override
		public String addUser(UserDTO userDTO) {
			User user = UserMapper.toEntity(userDTO);
			Credential credential = UserMapper.toCred(userDTO,user);
			userRepository.save(user);
			credential.setUser(user);
			credentialRepo.save(credential);
			return user.getUsername();
		}

	    @Override
	    public List<UserDTO> getUser() {

	        List<User> users = userRepository.findAll();
	        List<UserDTO> userDTOS = new ArrayList<>();
	        for(User user: users) {
	            userDTOS.add(UserMapper.toDto(user));
	        }

	        return userDTOS;
	    }

	@Override
	public Credential authenticate(String email, String password) {
		Credential credential = credentialRepo.findByEmail(email);
		return credential;
	}

}
