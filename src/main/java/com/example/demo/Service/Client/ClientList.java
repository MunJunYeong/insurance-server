package com.example.demo.Service.Client;

import com.example.demo.Domain.Client;

public interface ClientList {
    public String signUp(Client client);
    public Client signIn(String id, String pw);

}
