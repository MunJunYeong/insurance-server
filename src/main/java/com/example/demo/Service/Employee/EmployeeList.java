package com.example.demo.Service.Employee;

import com.example.demo.Domain.Accident;
import com.example.demo.Domain.Client;
import com.example.demo.Domain.Employee;
import com.example.demo.Form.AccidentForm;
import com.example.demo.Form.InsuranceForm;
import com.example.demo.Form.RuleForm;
import com.example.demo.Form.SuggestionForm;

import java.util.ArrayList;

public interface EmployeeList {
    //로그인
    public Employee signIn(String id, String pw);

    ////////////////////////////Salesman////////////////////////////
    public ArrayList<Client> getAllClient(); //client정보 가져오기
    public int postSuggestion(SuggestionForm suggestionForm);//제안서 등록하기
    public int postSubscription(SuggestionForm subscription);//청약서 등록하기


    ////////////////////////////designer////////////////////////////
    public int postInsurance(InsuranceForm insuranceForm);//보험 만들기


    ////////////////////////////uw////////////////////////////
    public int postUw(RuleForm ruleForm); //인수정책 수립
    public ArrayList<Client> getUwClient();
    public int postUwClient(int clientIdx);


    ////////////////////////////manager////////////////////////////
    public int postContractRule(RuleForm ruleForm); //계약관리 지침 작성

    ////////////////////////////handler////////////////////////////
    public ArrayList<Accident> getAccidentList();
    public Accident getAccident(int accidentIdx);;
    public int finishAccident(AccidentForm accidentForm);


    public ArrayList<Employee> select();

    public boolean add(Employee employee);
    public boolean delete(int employee_number);
    public Employee search(int employee_number);
    public boolean update(String TypeName, String Content, int index);
    public boolean update(String TypeName, int Content, int index);
    public int ShowSize();
    public String getEmployeeList(int index);



}
