package com.example.demo.Domain;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int employeeIdx;
    private String id;
    private String pw;
    private String name;
    private int tel;
    private String role;

//    @OneToMany
//    private List<Contract> employeeContract;
//    @OneToMany
//    private List<Accident> employeeAccident;
//    @OneToMany
//    private List<Insurance> employeeInsurance;

}
