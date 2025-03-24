package com.reservationapp.security.dtos;

import lombok.Data;

@Data
public class RegisterUserDto {    
    private String password;
    
    private String userName;
    
    private String email;
}
