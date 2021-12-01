package com.example.demo.Controller.Employee;

import com.example.demo.Form.RuleForm;
import com.example.demo.Service.Employee.EmployeeListImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/manager")
public class ManagerController {
    private final EmployeeListImpl employeeList;

    @PostMapping("/addContractRule")
    public int createContractGuideline(@RequestBody RuleForm ruleForm) {
        return employeeList.postContractRule(ruleForm);
    }

//    @PostMapping("/CreateTestGuidelines")
//    public void createTestGuideline(@RequestParam String guideline) {
//        TestGuidelines.add(guideline);
//    }
}