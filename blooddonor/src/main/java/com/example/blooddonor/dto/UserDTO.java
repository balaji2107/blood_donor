package com.example.blooddonor.dto;

import com.example.blooddonor.model.Credential;
import com.example.blooddonor.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String username;
    private String password;
    private String role;
    private String email;
    private String mobileNo;
    private User user;
}
