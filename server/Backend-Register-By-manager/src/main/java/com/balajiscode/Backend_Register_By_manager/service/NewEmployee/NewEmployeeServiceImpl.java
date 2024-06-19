package com.balajiscode.Backend_Register_By_manager.service.NewEmployee;

import com.balajiscode.Backend_Register_By_manager.dto.NewEmployeeDto;
import com.balajiscode.Backend_Register_By_manager.entity.EmployeeData;
import com.balajiscode.Backend_Register_By_manager.entity.UserAuthentication;
import com.balajiscode.Backend_Register_By_manager.repository.EmployeeDataRepository;
import com.balajiscode.Backend_Register_By_manager.repository.UserAuthenticationRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class NewEmployeeServiceImpl implements NewEmployeeService {

    private final UserAuthenticationRepository userAuthenticationRepository;
    private final EmployeeDataRepository employeeDataRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    NewEmployeeServiceImpl(UserAuthenticationRepository userAuthenticationRepository,
                           EmployeeDataRepository employeeDataRepository,
                           JavaMailSender javaMailSender){
        this.employeeDataRepository=employeeDataRepository;
        this.userAuthenticationRepository=userAuthenticationRepository;
        this.javaMailSender=javaMailSender;
    }

    NewEmployeeDto main = new NewEmployeeDto();

    @Override
    public boolean managerVerification(NewEmployeeDto newEmployeeDto) throws MessagingException {
        main=newEmployeeDto;
        if(newEmployeeDto!=null){
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");
            helper.setTo("balajis07032005@gmail.com");
            helper.setSubject("New Employee Verification");
            String htmlBody = "<html><body><h1>Hello Manager,</h1>"+"\n"
                    +"<h3>Here is the New Employee Details</h3>"+"\n"
                    +newEmployeeDto.getName()+"\n"
                    +newEmployeeDto.getDivision()+"\n"
                    +newEmployeeDto.getRole()+"\n"
                    +"<a href="+"http://localhost:8080/api/accept/"+newEmployeeDto.getEmail()+">" +
                    "<button style=\"display: inline-block; padding: 10px 20px; font-size: 16px; color: white; background-color: green; text-align: center; text-decoration: none; border-radius: 5px;\">ACCEPT</button></a>"+"\n"
                    +"<a href="+"http://localhost:8080/api/reject/"+newEmployeeDto.getEmail()+">" +
                    "<button style=\"display: inline-block; padding: 10px 20px; font-size: 16px; color: white; background-color: red; text-align: center; text-decoration: none; border-radius: 5px;\">REJECT</button></a>"+"\n"
                    +"<h1>Thank You!!</h1></body></html>";
            helper.setText(htmlBody,true);
            javaMailSender.send(message);
            return true;
        }
        return false;
    }

    private void sendResultMail(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    @Override
    public void managerAcceptance(String toEmail) {

        sendResultMail(toEmail,
                "Registration Verification Result by Manager",
                "ACCEPTED");

        EmployeeData emp = new EmployeeData(main.getName(),main.getDivision(),main.getRole());
        employeeDataRepository.save(emp);

        UserAuthentication user = new UserAuthentication(emp.getId(),main.getEmail(),main.getPassword());
        userAuthenticationRepository.save(user);

    }

    @Override
    public void managerRejection(String toEmail) {
        sendResultMail(toEmail,
                "Registration Verification Result by Manager",
                "REJECTED");
    }
}
