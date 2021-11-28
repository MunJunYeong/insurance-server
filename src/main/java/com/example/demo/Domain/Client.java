package com.example.demo.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Data
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long clientIdx;

    private String id;
    private String pw;
    private String name;
    private String email;
    private int ssn;
    private int tel;
    private String address;
    private int age;
    private String sex;
}
