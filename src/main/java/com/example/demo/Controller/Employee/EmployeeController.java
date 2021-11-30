package com.example.demo.Controller.Employee;

import com.example.demo.Service.Employee.EmployeeListImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/Employee")
public class EmployeeController {

    EmployeeListImpl employeeList;

    @PostMapping("/GetEmployee")
    public String getEmployeeList() {
        String List = "";
        for(int i = 0 ; i<employeeList.ShowSize();i++) {
            List += employeeList.getEmployeeList(i)+"\n";
        }
        return List;
    }

//    @PostMapping("/GetEmployee2")
//    public ArrayList<Employee> getEmployee2() {
//        return employeeList.select();
//    }

}
