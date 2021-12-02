package com.example.demo.Controller.Employee;

import com.example.demo.Domain.Client;
import com.example.demo.Domain.Contract;
import com.example.demo.Form.SubscriptionForm;
import com.example.demo.Form.SuggestionForm;
import com.example.demo.Service.Employee.EmployeeListImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/salesman")
public class SalesmanController {
    private final EmployeeListImpl employeeList;

    @GetMapping("/clientList")
    public ArrayList<Client> getClientList(){
        ArrayList<Client> client = employeeList.getAllClient();
        return client;
    }
    @GetMapping("contractCheckMoney")
    public ArrayList<Contract> getContractCheckForm(){
        return employeeList.getContractCheckForm();
    }
    //form타입은 새로 만드는게 중복되어서 사용
    @PostMapping("/finalPayment")
    public int postFinalPayment(@RequestBody SubscriptionForm form){
        int contractIdx = form.getContractIdx();
        return employeeList.postFinalPayment(contractIdx);
    }
    @GetMapping("getfinalContract")
    public ArrayList<Contract> getFinalContract(){
        return employeeList.getFinalContract();
    }
    @PostMapping("/finalContract")
    public int postFinalContract(@RequestBody SubscriptionForm form){
        int contractIdx = form.getContractIdx();
        return employeeList.postFinalContract(contractIdx);
    }
    @PostMapping("/addSuggest")
    public int postSuggestion(@RequestBody SuggestionForm suggestionForm){
        return employeeList.postSuggestion(suggestionForm);
    }
    @PostMapping("/addSubscription")
    public int postSubscription(@RequestBody SuggestionForm subscription){
        return employeeList.postSubscription(subscription);
    }

}
