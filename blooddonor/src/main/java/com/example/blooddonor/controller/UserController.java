package com.example.blooddonor.controller;

import java.util.List;

import com.example.blooddonor.dto.CredentialDTO;
import com.example.blooddonor.model.Credential;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.blooddonor.dto.UserDTO;
import com.example.blooddonor.service.IUserService;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


	@Autowired
    private IUserService userBusinessService;
	
	@PostMapping("/addUser")
    public String addUser(UserDTO userDTO)  {
        logger.info("Received addUser request: {}", userDTO);
        String newUser = userBusinessService.addUser(userDTO);
        return "index";
    }

    @GetMapping("/getUser")
    public List<UserDTO> getUser() {
        List<UserDTO> newUser = userBusinessService.getUser();
        return newUser;
    }

    @PostMapping("/login")
    public String login(CredentialDTO credential,HttpSession session)  {
        String email = credential.getEmail();
        String password = credential.getPassword();
        Credential credential1=userBusinessService.authenticate(email,password);
        if(credential1 != null){
            boolean flag=credential1.getUser().isFlag();
            session.setAttribute("flag",flag);
            return "redirect:/home?fragmentToLoad=dashboard";
        }else
         return "redirect:/login";
    }

}
