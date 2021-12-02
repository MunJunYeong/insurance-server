package com.example.demo.Service.Accident;


import com.example.demo.Domain.Accident;
import com.example.demo.Form.AccidentForm;
import com.example.demo.Repository.AccidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
@Transactional() // data 변경하는 부분 이노테이션
public class AccidentListImpl implements AccidentList {
    private final ArrayList<Accident> accidentList;

    private final AccidentRepository accidentRepository;

    public boolean addAccident(AccidentForm accident) {
        accidentRepository.postAccident(accident);
        return true;
    }
    @Override
    public ArrayList<Accident> getMyAccident(int clientIdx) {
        return accidentRepository.getMyAccident(clientIdx);
    }
    @Override
    public int addLawsuit(AccidentForm accidentForm) {
        return accidentRepository.postLawsuit(accidentForm);
    }


    @Override
    public ArrayList<Accident> select() {
        return accidentList;
    }

    public Accident search(int accidentId) {
        return accidentList.get(accidentId);
    }

    public boolean delete(int accidentId) {
        this.accidentList.remove(accidentId);
        return true;
    }



    public int ShowSize() {
        return this.accidentList.size();
    }

    public boolean update(String TypeName, String Content, int index) {
        switch (TypeName) {

            case "accidentDate":
//                accidentList.get(index).setDate(Content);
                return true;
            case "kindsOfAccident":
//                accidentList.get(index).setKindsOfAccident(Content);
                return true;

        }
        return true;
    }

    public boolean update(String TypeName, int Content, int index) {
        switch (TypeName) {

            case "accidentTime":
//                accidentList.get(index).setDate(Content);
                return true;
            case "amountOfDamage":
                accidentList.get(index).setDamagePrice(Content);
                return true;
            case "calculatedInsuranceFee":
//                accidentList.get(index).setCalculatedInsuranceFee(Content);
                return true;
            case "customerId":
//                accidentList.get(index).setClientIdx(Content);
                return true;
            case "contractId":
//                accidentList.get(index).setContractId(Content);
                return true;
            case "customerRegistrationNumber":
//                accidentList.get(index).setCustomerRegistrationNumber(Content);
                return true;
        }
        return true;
    }

    public String getAccidentList(int i) {
//        String List = this.accidentList.get(i).getAccidentIdx() + " / " + this.accidentList.get(i).getContractId() + " / "
//                + this.accidentList.get(i).getDate() + " / " + this.accidentList.get(i).getAccidentTime()
//                + " / " + this.accidentList.get(i).getAmountOfDamage() + " / "
//                + this.accidentList.get(i).getMeasuredPrice() + " / " + this.accidentList.get(i).getCustomerId()
//                + " / " + this.accidentList.get(i).getCustomerRegistrationNumber()+ " / " + this.accidentList.get(i).getKindsOfAccident();
//        return List;
        return null;
    }

}