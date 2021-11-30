package com.example.demo.Controller;

import com.example.demo.Domain.Client;
import com.example.demo.Domain.Employee;
import com.example.demo.Form.LoginForm;
import com.example.demo.Service.Client.ClientListImpl;
import com.example.demo.Service.Employee.EmployeeListImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SignController {
    private final ClientListImpl clientService;
    private final EmployeeListImpl employeeService;

    @PostMapping("/signUp")
    public String signUp(@RequestBody Client client){
        clientService.signUp(client);
        return "성공";
    }

    @PostMapping("/client/signIn")
    public Client clientSignInForm(@RequestBody LoginForm loginForm){
        Client client = clientService.signIn(loginForm.getId(), loginForm.getPw());
        log.info("client  {}", client);
        return client;
    }
    @PostMapping("/admin/signIn")
    public Employee adminSignInForm(@RequestBody LoginForm loginForm){
        Employee employee = employeeService.signIn(loginForm.getId(), loginForm.getPw());
        return employee;
    }
}
