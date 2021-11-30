package com.example.demo.Service.Employee;

import com.example.demo.Domain.Client;
import com.example.demo.Domain.Employee;
import com.example.demo.Form.SuggestionForm;

import java.util.ArrayList;

public interface EmployeeList {
    //로그인
    public Employee signIn(String id, String pw);
    //client정보 가져오기
    public ArrayList<Client> getAllClient();
    //제안서 등록하기
    public int postSuggestion(SuggestionForm suggestionForm);
    public ArrayList<Employee> select();

    public boolean add(Employee employee);
    public boolean delete(int employee_number);
    public Employee search(int employee_number);
    public boolean update(String TypeName, String Content, int index);
    public boolean update(String TypeName, int Content, int index);
    public int ShowSize();
    public String getEmployeeList(int index);

}
