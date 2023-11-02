package com.example.authservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class JwtRespone {

    private String jwtToken;

    private String username;

}
