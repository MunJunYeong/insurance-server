package com.example.demo.Controller.Employee;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/Customer")
public class ManagerController {

    ArrayList<String> ContractGuidelines = new ArrayList<String>();
    ArrayList<String> TestGuidelines= new ArrayList<String>();

    //계약관리지침수립
    @PostMapping("/CreateContractGuidelines")
    public void createContractGuideline(@RequestParam String guideline) {
        ContractGuidelines.add(guideline);

    }

    @PostMapping("/CreateTestGuidelines")
    public void createTestGuideline(@RequestParam String guideline) {
        TestGuidelines.add(guideline);

    }
}