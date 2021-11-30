package com.example.demo.Controller.Employee;

import com.example.demo.Domain.Client;
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
    @PostMapping("/addSuggest")
    public int postSuggestion(@RequestBody SuggestionForm suggestionForm){
        int idx = employeeList.postSuggestion(suggestionForm);
        return idx;
    }
    @PostMapping("/addSubscription")
    public int postSubscription(@RequestBody SuggestionForm subscription){
        int idx = employeeList.postSubscription(subscription);
        return idx;
    }

}
