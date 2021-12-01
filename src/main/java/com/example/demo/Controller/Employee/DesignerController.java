package com.example.demo.Controller.Employee;

import com.example.demo.Form.InsuranceForm;
import com.example.demo.Service.Employee.EmployeeListImpl;
import com.example.demo.Service.Insurance.InsuranceListImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/designer")
public class DesignerController {
    private final InsuranceListImpl insuranceList;
    private final EmployeeListImpl employeeList;

    @PostMapping("/car")
    public int postInsuranceCar(@RequestBody InsuranceForm insuranceForm){
        int idx = employeeList.postInsurance(insuranceForm);
        return idx;
    }
    @PostMapping("/fire")
    public int postInsuranceFire(@RequestBody InsuranceForm insuranceForm){
        int idx = employeeList.postInsurance(insuranceForm);
        return idx;
    }
    @PostMapping("/industrial")
    public int postInsuranceIndustrial(@RequestBody InsuranceForm insuranceForm){
        int idx = employeeList.postInsurance(insuranceForm);
        return idx;
    }
    @PostMapping("/life")
    public int postInsuranceLife(@RequestBody InsuranceForm insuranceForm){
        int idx = employeeList.postInsurance(insuranceForm);
        return idx;
    }

}
