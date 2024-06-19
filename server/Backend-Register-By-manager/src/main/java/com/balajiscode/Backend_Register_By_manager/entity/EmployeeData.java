package com.balajiscode.Backend_Register_By_manager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employee_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "division")
    private String division;

    @Column(name = "role")
    private String role;


    public EmployeeData(String name, String division, String role) {
        this.name=name;
        this.division=division;
        this.role=role;
    }
}
