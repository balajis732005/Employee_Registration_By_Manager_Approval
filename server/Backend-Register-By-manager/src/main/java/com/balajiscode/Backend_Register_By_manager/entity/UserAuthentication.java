package com.balajiscode.Backend_Register_By_manager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user_authetication")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_id")
    private Long empId;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "password")
    private String password;

    public UserAuthentication(Long empId, String email, String password) {
        this.empId = empId;
        this.email = email;
        this.password = password;
    }
}
