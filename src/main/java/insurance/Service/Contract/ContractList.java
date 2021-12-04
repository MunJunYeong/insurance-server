package insurance.Service.Contract;

import insurance.Domain.Client;
import insurance.Domain.Contract;

import java.util.ArrayList;

public interface ContractList {
    public String getSuggestion(int clientIdx);
    public String getSubscription(int clientIdx);

    public ArrayList<Contract> select();
    public boolean add(Contract contract);
    public boolean delete(int contractId);
    public Contract search(int contractId);
    public boolean update(String TypeName, String Content, int index);
    public boolean update(String TypeName, int Content, int index);
    public int ShowSize();
    public String getContractList(int i);
    public boolean update(String testing, boolean test, int index);

    public boolean SelectCustomer(Client search);
    public boolean setEmployee(int employeeIdx);
    public boolean FinalContract(boolean check);
    public void WriteProposal(String content);



}
