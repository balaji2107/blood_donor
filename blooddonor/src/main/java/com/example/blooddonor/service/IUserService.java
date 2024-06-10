package com.example.blooddonor.service;

import java.util.List;

import com.example.blooddonor.dto.CredentialDTO;
import com.example.blooddonor.dto.UserDTO;

public interface IUserService {

    String addUser(UserDTO userDTO,CredentialDTO credentialDTO);

    List<UserDTO> getUser();

}
