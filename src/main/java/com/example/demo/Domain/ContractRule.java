package com.example.demo.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
public class ContractRule {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ruleIdx;

    private String contractRuleEstablish;

    @ManyToOne
    @JoinColumn(name = "employeeIdx")
    private Employee employee;
}
