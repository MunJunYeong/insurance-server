package com.example.demo.Repository;

import com.example.demo.Domain.ContractRule;
import com.example.demo.Domain.Employee;
import com.example.demo.Domain.UwRule;
import com.example.demo.Form.RuleForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class RuleRepository {
    private final EntityManager em;

    public int postUw(RuleForm ruleForm) {
        UwRule uwRule = new UwRule();
        Employee employee = findEmployeeOne(ruleForm.getEmployeeIdx());
        uwRule.setEmployee(employee);
        uwRule.setUwEstablish(ruleForm.getContent());
        em.persist(uwRule);
        return uwRule.getRuleIdx();
    }
    public Employee findEmployeeOne(int idx){
        return em.find(Employee.class, idx);
    }

    public int postContractRule(RuleForm ruleForm) {
        ContractRule contractRule = new ContractRule();
        Employee employee = findEmployeeOne(ruleForm.getEmployeeIdx());
        contractRule.setEmployee(employee);
        contractRule.setContractRuleEstablish(ruleForm.getContent());
        em.persist(contractRule);
        return contractRule.getRuleIdx();
    }
}
