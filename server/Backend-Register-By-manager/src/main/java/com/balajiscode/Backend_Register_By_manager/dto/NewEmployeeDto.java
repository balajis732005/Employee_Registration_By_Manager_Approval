package com.balajiscode.Backend_Register_By_manager.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewEmployeeDto {

    private String name;

    private String email;

    private String password;

    private String division;

    private String role;

}
