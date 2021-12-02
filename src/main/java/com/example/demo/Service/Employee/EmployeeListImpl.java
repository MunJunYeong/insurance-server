package com.example.demo.Service.Employee;

import com.example.demo.Domain.Accident;
import com.example.demo.Domain.Client;
import com.example.demo.Domain.Contract;
import com.example.demo.Domain.Employee;
import com.example.demo.Form.AccidentForm;
import com.example.demo.Form.InsuranceForm;
import com.example.demo.Form.RuleForm;
import com.example.demo.Form.SuggestionForm;
import com.example.demo.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
@Transactional // data 변경하는 부분 이노테이션
public class EmployeeListImpl implements  EmployeeList {
    private final EmployeeRepository employeeRepository;
    private final RuleRepository ruleRepository;
    private final InsuranceRepository insuranceRepository;
    private final AccidentRepository accidentRepository;
    private final ContractRepository contractRepository;


    private final ArrayList<Employee> employeeList;//버려야됨

    @Override
    public Employee signIn(String id, String pw) {
        return employeeRepository.findByLoginId(id)
                .filter(e -> e.getPw().equals(pw))
                .orElse(null);
    }
    ////////////////////////////Salesman////////////////////////////
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
    @Override
    public ArrayList<Contract> getContractCheckForm() {
        return contractRepository.getContractCheckForm();
    }
    @Override
    public int postFinalPayment(int contractIdx) {
        return contractRepository.postFinalPayment(contractIdx);
    }

    ////////////////////////////designer////////////////////////////
    @Override
    public int postInsurance(InsuranceForm insuranceForm) {
        return insuranceRepository.postInsurance(insuranceForm);
    }

    ////////////////////////////uw////////////////////////////
    @Override
    public int postUw(RuleForm ruleForm) {
        return ruleRepository.postUw(ruleForm);
    }
    @Override
    public ArrayList<Client> getUwClient() {
        return employeeRepository.findUwClient();
    }
    @Override
    public int postUwClient(int clientIdx) {
        return employeeRepository.postUwClient(clientIdx);
    }


    ////////////////////////////manager////////////////////////////
    @Override
    public int postContractRule(RuleForm ruleForm) {
        return ruleRepository.postContractRule(ruleForm);
    }


    ////////////////////////////handler////////////////////////////
    @Override
    public ArrayList<Accident> getAccidentList() {
        return accidentRepository.getAccidentList();
    }
    @Override
    public Accident getAccident(int accidentIdx) {
        return accidentRepository.getAccident(accidentIdx);
    }
    @Override
    public int finishAccident(AccidentForm accidentForm) {
        return accidentRepository.finishAccident(accidentForm);
    }


    public ArrayList<Employee> select() {
        return employeeList;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
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
