package com.example.blooddonor.controller;

import java.util.List;

import com.example.blooddonor.dto.CredentialDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.blooddonor.dto.UserDTO;
import com.example.blooddonor.service.IUserService;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


	@Autowired
    private IUserService userBusinessService;
	
	@PostMapping("/addUser")
    public String addUser(UserDTO userDTO,CredentialDTO credentialDTO)  {
        logger.info("Received addUser request: {}", userDTO);
        String newUser = userBusinessService.addUser(userDTO,credentialDTO);
        System.out.println(newUser);
        return "index";
    }

    @GetMapping("/getUser")
    public List<UserDTO> getUser() {
        List<UserDTO> newUser = userBusinessService.getUser();
        return newUser;
    }
}
