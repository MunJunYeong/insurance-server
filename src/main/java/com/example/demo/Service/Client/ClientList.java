package com.example.demo.Service.Client;

import com.example.demo.Domain.Client;

import java.util.ArrayList;

public interface ClientList {
    public String signUp(Client client);
    public Client signIn(String id, String pw);
    // employee = salesman 이 가져올 때 사용
    public Client getClientData(int clientIdx);

    public ArrayList<Client> select();
    public boolean delete(int clientIdx);

    public boolean update(String TypeName, String Content, int index);
    public boolean update(String TypeName, int Content, int index);
    public int ShowSize();
    public String getCustomerList(int i);

}
