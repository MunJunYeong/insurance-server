package com.example.demo.Repository;

import com.example.demo.Domain.Contract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContractRepository {
    private final EntityManager em;

    public String getSuggestion(int clientIdx) {
        Contract contract = new Contract();
        List<Contract> contractList = findContractAll();
        for(int i=0; i < contractList.size(); i++){
            if(contractList.get(i).getClient().getClientIdx() == clientIdx){
                if (!contractList.get(i).getCheckForm()){
                    contract = contractList.get(i);
                }
            }
        }
        if(contract == null) {
            return null;
        }
        return contract.getSuggestion();
    }
    public String getSubscription(int clientIdx) {
        Contract contract = new Contract();
        List<Contract> contractList = findContractAll();
        for(int i=0; i < contractList.size(); i++){
            if(contractList.get(i).getClient().getClientIdx() == clientIdx){
                if (!contractList.get(i).getCheckForm()){
                    contract = contractList.get(i);
                }
            }
        }
        if(contract == null) {
            return null;
        }
        System.out.println(contract.getContractIdx());
        return contract.getSubscription();
    }
    public ArrayList<Contract> getContractCheckForm() {
        ArrayList<Contract> contractArrayList = (ArrayList<Contract>) findContractAll();
        ArrayList<Contract> contracts = new ArrayList<Contract>();
        for (int i =0; i< contractArrayList.size(); i++){
            if(contractArrayList.get(i).getCheckForm() && !contractArrayList.get(i).getCheckMoney() ){
                contracts.add(contractArrayList.get(i));
            }
        }
        return contracts;
    }
    public int postFinalPayment(int contractIdx) {
        Contract contract = findContractOne(contractIdx);
        contract.setCheckMoney(true);
        return contract.getContractIdx();
    }


    private List<Contract> findContractAll() {
        return em.createQuery("select c from Contract c", Contract.class).getResultList();
    }
    private Contract findContractOne(int contractIdx) {
        return em.find(Contract.class, contractIdx);
    }



}
