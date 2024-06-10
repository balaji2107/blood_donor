package com.example.blooddonor.service;

import java.util.List;

import com.example.blooddonor.dto.CredentialDTO;
import com.example.blooddonor.dto.UserDTO;
import com.example.blooddonor.model.Credential;

public interface IUserService {

    String addUser(UserDTO userDTO);

    List<UserDTO> getUser();

    Credential authenticate(String email, String password);
}
