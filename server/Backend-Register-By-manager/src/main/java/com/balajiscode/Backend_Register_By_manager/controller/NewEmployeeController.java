package com.balajiscode.Backend_Register_By_manager.controller;

import com.balajiscode.Backend_Register_By_manager.dto.NewEmployeeDto;
import com.balajiscode.Backend_Register_By_manager.service.NewEmployee.NewEmployeeService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class NewEmployeeController {

    private final NewEmployeeService newEmployeeService;

    @Autowired
    NewEmployeeController(NewEmployeeService newEmployeeService){
        this.newEmployeeService=newEmployeeService;
    }

    @PostMapping("/api/manager")
    boolean managerVerification(@RequestBody NewEmployeeDto newEmployeeDto) throws MessagingException {
        return this.newEmployeeService.managerVerification(newEmployeeDto);
    }

    @GetMapping("/api/accept/{toEmail}")
    void managerAcceptance(@PathVariable String toEmail) {
        this.newEmployeeService.managerAcceptance(toEmail);
    }

    @GetMapping("/api/reject/{toEmail}")
    void managerRejection(@PathVariable String toEmail) {
        this.newEmployeeService.managerRejection(toEmail);
    }

}
