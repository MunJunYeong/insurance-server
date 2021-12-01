package com.example.demo.Repository;

import com.example.demo.Domain.Client;
import com.example.demo.Domain.Contract;
import com.example.demo.Domain.Employee;
import com.example.demo.Domain.Insurance.Insurance;
import com.example.demo.Form.SuggestionForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {
    private final EntityManager em;


    public Optional<Employee> findByLoginId(String loginId){
        //findAll().stream() 루프를 돌면서 찾는다
        return findAll().stream().filter(
                        e -> e.getId().equals(loginId))
                .findFirst();
    }
    private List<Employee> findAll() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }
    //모든 client찾기
    public ArrayList<Client> findAllClient() {
        return (ArrayList<Client>) em.createQuery("select c from Client c", Client.class).getResultList();
    }
    //////////////////////////////////////////////////////////////////////
    public int postSuggestion(SuggestionForm suggestionForm) {
        Contract contract = new Contract();

        Client client = findClientOne(suggestionForm.getClientIdx());
        if(client == null){
            return 0;
        }
        if(client.isHaveSuggest()){
            return -1;
        }
        Employee employee = findEmployeeOne(suggestionForm.getEmployeeIdx());
        Optional<Insurance> insurance = findByType(suggestionForm.getInsuranceType());
        contract.setEmployee(employee);
        contract.setSuggestion(suggestionForm.getContent());
        contract.setInsurance(insurance.get());
        contract.setClient(client);
        client.setHaveSuggest(true);
        em.persist(contract);
        return  contract.getContractIdx();
    }

    //보험찾는 로직
    private List<Insurance> findInsuranceAll() {
        return em.createQuery("select i from Insurance i", Insurance.class).getResultList();
    }
    private Optional<Insurance> findByType(String insuranceType) {
        return findInsuranceAll().stream().filter(
                        i -> i.getDecriminatorValue().equals(insuranceType))
                .findFirst();
    }
    public Client findClientOne(int idx) {
        return em.find(Client.class, idx);
    }
    public Employee findEmployeeOne(int idx){
        return em.find(Employee.class, idx);
    }
    //////////////////////////////////////////////////////////////////////
    public int postSubscription(SuggestionForm subscription) {
        //clientIdx, ContractIdx, employeeIdx, 청약서
        Contract contract = findContractOne(subscription.getContractIdx());
        Client client = findClientOne(subscription.getClientIdx());
        if(client == null){
            return 0;
        }
        if(!client.isHaveSuggest()){
            return -1;
        }
        if(client.isHaveSubscription()){
            return -2;
        }
        contract.setSubscription(subscription.getContent());
        client.setHaveSubscription(true);
        return contract.getContractIdx();
    }
    public Contract findContractOne(int idx){
        return em.find(Contract.class, idx);
    }

    //UW 고객 찾기
    public ArrayList<Client> findUwClient() {
        ArrayList<Contract> contractArrayList = findAllContract();
        ArrayList<Client> clientArrayList = new ArrayList<Client>();
        for(int i =0; i < contractArrayList.size(); i++){
            if(contractArrayList.get(i).getSubscription() !=null && contractArrayList.get(i).getSubscription() !=null && !contractArrayList.get(i).getCheckForm()){
                clientArrayList.add(contractArrayList.get(i).getClient());
            }
        }
        return clientArrayList;
    }
    //모든 Contract
    public ArrayList<Contract> findAllContract() {
        return (ArrayList<Contract>) em.createQuery("select c from Contract c", Contract.class).getResultList();
    }

    public int postUwClient(int clientIdx) {
        ArrayList<Contract> contractArrayList = findAllContract();
        Contract contract = new Contract();
        for(int i =0; i < contractArrayList.size(); i++){
            if(contractArrayList.get(i).getClient().getClientIdx() == clientIdx){
                contract = contractArrayList.get(i);
            }
        }
        if(contract.getContractIdx() == -1){
            return 0;
        }else {
            contract.setCheckForm(true);
            System.out.println(clientIdx);
            return clientIdx;
        }
    }
}
