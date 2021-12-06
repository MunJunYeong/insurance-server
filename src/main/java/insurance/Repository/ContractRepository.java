package insurance.Repository;

import insurance.Domain.Contract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            if(contractArrayList.get(i).getCheckForm() && !contractArrayList.get(i).getCheckMoney() && !contractArrayList.get(i).getFinalContract() ){
                contracts.add(contractArrayList.get(i));
            }
        }
        return contracts;
    }
    public ArrayList<Contract> getFinalContract() {
        ArrayList<Contract> contractArrayList = (ArrayList<Contract>) findContractAll();
        ArrayList<Contract> contracts = new ArrayList<Contract>();
        for (int i =0; i< contractArrayList.size(); i++){
            if(contractArrayList.get(i).getCheckForm() && contractArrayList.get(i).getCheckMoney() && !contractArrayList.get(i).getFinalContract()){
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
    public int postFinalContract(int contractIdx) {
        Contract contract = findContractOne(contractIdx);
        Date date = new Date();
        contract.setCreated(date);
        contract.setFinalContract(true);
        return contract.getContractIdx();
    }
    public ArrayList<Contract> getExpirationContract() throws ParseException {
        ArrayList<Contract> contractArrayList = (ArrayList<Contract>) findContractAll();
        ArrayList<Contract> contracts = new ArrayList<Contract>();
        if(contractArrayList == null){
            return null;
        }
        for (int i =0; i< contractArrayList.size(); i++){
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String insuranceDataString = contractArrayList.get(i).getInsurance().getPeriod();
            boolean finish= false;
            if(contractArrayList.get(i).getCreated()==null){

            }else{
                Date contractDate = contractArrayList.get(i).getCreated();
                Date insuranceDate = dateFormat.parse(insuranceDataString);
                if(insuranceDate.after(contractDate)){
                    finish = true; //보험기간이 아직 남아있다.
                }
                if(!finish) {
                    contracts.add(contractArrayList.get(i));
                }
            }
        }
        return contracts;
    }
    public int deleteContract(int contractIdx) {
        Contract contract = findContractOne(contractIdx);
        if(contract == null){
            return 0;
        }
        em.remove(contract);
        return 1;
    }



    private List<Contract> findContractAll() {
        return em.createQuery("select c from Contract c", Contract.class).getResultList();
    }
    private Contract findContractOne(int contractIdx) {
        return em.find(Contract.class, contractIdx);
    }



}
