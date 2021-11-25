package com.example.demo.Controller;

import com.example.demo.Domain.Client;
import com.example.demo.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignController {
    private final ClientService clientService;

    @PostMapping("/signUp")
    public String signUp(@RequestBody Client client){
        clientService.signUp(client);
        return "성공";
    }

    @PostMapping("/client/signIn")
    public String clientSignInForm(@RequestBody String obj ){
        System.out.println(obj);
        return null;
    }
    @PostMapping("/admin/signIn")
    public String adminSignInForm(){
        return null;
    }



}
