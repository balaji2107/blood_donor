package com.example.blooddonor.dto;

import com.example.blooddonor.model.Credential;
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
    private String email;
    private String mobileNo;
    private Credential credential;
}
