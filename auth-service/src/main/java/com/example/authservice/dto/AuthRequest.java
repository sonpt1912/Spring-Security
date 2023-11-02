package com.example.authservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthRequest {

    private String username;

    private String password;

}
