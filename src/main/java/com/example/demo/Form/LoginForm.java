package com.example.demo.Form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
    private String id;
    private String pw;

    public LoginForm(String id, String pw){
        this.id = id;
        this.pw = pw;
    }

}
