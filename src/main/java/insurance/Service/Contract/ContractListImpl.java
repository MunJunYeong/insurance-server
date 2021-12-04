package insurance.Service.Contract;

import insurance.Domain.Client;
import insurance.Domain.Contract;
import insurance.Repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
@Transactional // data 변경하는 부분 이노테이션
public class ContractListImpl implements  ContractList {
    private final ContractRepository contractRepository;

    private final ArrayList<Contract> contractList;

    @Override
    public String getSuggestion(int clientIdx) {
        return contractRepository.getSuggestion(clientIdx);
    }
    @Override
    public String getSubscription(int clientIdx) {
        return contractRepository.getSubscription(clientIdx);
    }

    public ArrayList<Contract> select() {
        return contractList;
    }

//    public ContractListImpl() {
//        this.contractList = new ArrayList<Contract>();
//    }

    public boolean delete(int contractId) {
        this.contractList.remove(contractId);
        return true;
    }

    public Contract search(int contractId) {
        return contractList.get(contractId);
    }



    public boolean add(Contract contract) {
        this.contractList.add(contract);
        return true;
    }

    public int ShowSize() {
        return this.contractList.size();
    }


    public boolean update(String TypeName, boolean Content, int index) {
        switch (TypeName) {

            case "Testing":
//                contractList.get(index).setTesting(Content);
                return true;


        }
        return true;
    }
    @Override
    public boolean update(String TypeName, String Content, int index) {
        switch (TypeName) {

            case "Testing":
//                contractList.get(index).setTesting(Content);
                return true;


        }
        return true;
    }
    @Override
    public String getContractList(int i) {
        return null;
    }


    public boolean update(String TypeName, int Content, int index) {
        switch (TypeName) {

            case "contractIdx":
                contractList.get(index).setContractIdx(Content);
                return true;
            case "customerIdx":
//                contractList.get(index).setCustomerIdx(Content);
                return true;
            case "EmployeeId":
//                contractList.get(index).setEmployeeIdx(Content);
                return true;

        }
        return true;
    }

    public String getAccidentList(int i) {
//        String List = this.contractList.get(i).getContractIdx() + " / " + this.contractList.get(i).getCustomerIdx() + " / "
//                + this.contractList.get(i).getEmployeeId() + " / " + this.contractList.get(i).getTesting();
//        ;
//        return List;
        return null;
    }

    @Override
    public boolean SelectCustomer(Client search) {
//        contract.setCustomerIdx(search.getCustomerIdx());
//        contract.setContractIdx(0);//임시
        return true;
    }

    @Override
    public boolean setEmployee(int employeeIdx) {
//        contract.setEmployeeId(employeeIdx);
        return false;
    }

    @Override
    public boolean FinalContract(boolean check) {
//        if(contract.getTesting()==true&&contract.getCheckMoney()==true){
//            contract.setTesting(check);
//            return true;
//        }else {
//            return false;
//        }
        return false;
    }


    @Override
    public void WriteProposal(String content) {
//        proposal = content;
    }
}
