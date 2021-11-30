package com.example.demo.Service.Employee;

import com.example.demo.Domain.Employee;

import java.util.ArrayList;

public interface EmployeeList {
    public Employee signIn(String id, String pw);
    public ArrayList<Employee> select();
    public boolean add(Employee employee);
    public boolean delete(int employee_number);
    public Employee search(int employee_number);
    public boolean update(String TypeName, String Content, int index);
    public boolean update(String TypeName, int Content, int index);
    public int ShowSize();
    public String getEmployeeList(int index);

}
