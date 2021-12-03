package com.example.demo.Controller.Employee;

import com.example.demo.Domain.Contract;
import com.example.demo.Form.RuleForm;
import com.example.demo.Form.SuggestionForm;
import com.example.demo.Service.Employee.EmployeeListImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/manager")
public class ManagerController {
    private final EmployeeListImpl employeeList;

    @PostMapping("/contractRule")
    public int createContractGuideline(@RequestBody RuleForm ruleForm) {
        return employeeList.postContractRule(ruleForm);
    }
    @GetMapping("/expirationContract")
    public ArrayList<Contract> getExpirationContract() throws ParseException {
        return employeeList.getExpirationContract();
    }
    @PostMapping("/deleteContract")
    public int deleteContract(@RequestBody SuggestionForm form){
        int contractIdx = form.getContractIdx();
        return employeeList.deleteContract(contractIdx);
    }

//    @PostMapping("/CreateTestGuidelines")
//    public void createTestGuideline(@RequestParam String guideline) {
//        TestGuidelines.add(guideline);
//    }
}