package com.example.demo.Controller.Employee;

import com.example.demo.Domain.Accident;
import com.example.demo.Service.Employee.EmployeeListImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/handler")
public class HandlerController {
    private final EmployeeListImpl employeeList;

    @GetMapping("/accidentList")
    public ArrayList<Accident> getAccidentList(){
        ArrayList<Accident> accident = employeeList.getAccident();
        return accident;
    }

}
