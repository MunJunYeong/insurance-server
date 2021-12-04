package insurance.Controller;

import insurance.Domain.Client;
import insurance.Domain.Employee;
import insurance.Form.LoginForm;
import insurance.Service.Client.ClientListImpl;
import insurance.Service.Employee.EmployeeListImpl;
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
