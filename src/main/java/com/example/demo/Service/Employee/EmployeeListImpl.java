package com.example.demo.Service.Employee;

import com.example.demo.Domain.Client;
import com.example.demo.Domain.Employee;
import com.example.demo.Form.SuggestionForm;
import com.example.demo.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
@Transactional // data 변경하는 부분 이노테이션
public class EmployeeListImpl implements  EmployeeList {
    private final EmployeeRepository employeeRepository;
    private final ArrayList<Employee> employeeList;

    @Override
    public Employee signIn(String id, String pw) {
        return employeeRepository.findByLoginId(id)
                .filter(e -> e.getPw().equals(pw))
                .orElse(null);
    }

    @Override
    public ArrayList<Client> getAllClient() {
        return employeeRepository.findAllClient();
    }
    @Override
    public int postSuggestion(SuggestionForm suggestionForm) {
        return  employeeRepository.postSuggestion(suggestionForm);
    }


    @Override
    public int postSubscription(SuggestionForm subscription) {
        return employeeRepository.postSubscription(subscription);
    }

    public ArrayList<Employee> select() {
        return employeeList;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
//        this.employeeList = employeeList;
    }

    public boolean add(Employee employee) {
        this.employeeList.add(employee);
        return true;
    }

    public boolean delete(int employeeNumber) {
        this.employeeList.remove(employeeNumber);
        return true;
    }

    public Employee search(int employeeNumber) {
        return this.employeeList.get(employeeNumber);
    }

    public int ShowSize() {
        return this.employeeList.size();
    }

    @Override
    public boolean update(String TypeName, String Content, int index) {
        employeeList.get(index);
        switch (TypeName) {
            case "ID":
                employeeList.get(index).setId(Content);
                return true;
            case "name":
                employeeList.get(index).setName(Content);
                return true;
            case "password":
                employeeList.get(index).setPw(Content);
                return true;
            case "email_address":
//                employeeList.get(index).setEmailAddress(Content);
                return true;
            case "position":
//                employeeList.get(index).setPosition(Content);
                return true;
        }
        return true;
    }

    @Override
    public boolean update(String TypeName, int Content, int index) {
        employeeList.get(index);
        switch (TypeName) {

            case "phone_number":
//                employeeList.get(index).setPhoneNumber(Content);
                return true;
            case "personal_registration_number":
//                employeeList.get(index).setPersonalRegistrationNumber(Content);
                return true;
        }
        return true;
    }

    @Override
    public String getEmployeeList(int i) {
//        String List = this.employeeList.get(i).getEmployeeIdx() + " / "+this.employeeList.get(i).getName() + " / " + this.employeeList.get(i).getPhoneNumber() + " / "
//                + this.employeeList.get(i).getEmailAddress() + " / " + this.employeeList.get(i).getPosition();
//        return List;
        return null;
    }


}
