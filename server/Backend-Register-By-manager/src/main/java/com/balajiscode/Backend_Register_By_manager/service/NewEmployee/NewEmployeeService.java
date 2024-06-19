package com.balajiscode.Backend_Register_By_manager.service.NewEmployee;

import com.balajiscode.Backend_Register_By_manager.dto.NewEmployeeDto;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface NewEmployeeService {

    boolean managerVerification(NewEmployeeDto newEmployeeDto) throws MessagingException;

    void managerAcceptance(String toEmail);

    void managerRejection(String toEmail);

}
