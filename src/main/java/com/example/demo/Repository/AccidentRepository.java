package com.example.demo.Repository;

import com.example.demo.Domain.Accident;
import com.example.demo.Domain.Client;
import com.example.demo.Domain.Employee;
import com.example.demo.Domain.Insurance.Insurance;
import com.example.demo.Form.AccidentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccidentRepository {
    private final EntityManager em;

    //client 사고 접수 로직
    public void postAccident(AccidentForm accidentData) {
        Accident accident = new Accident();

        Client client = findOne(accidentData.getClientIdx());
        Optional<Insurance> insurance = findByType(accidentData.getInsuranceType());

        accident.setContent(accidentData.getContent());
        accident.setDate(accidentData.getDate());
        accident.setDamagePrice(accidentData.getDamagePrice());
        accident.setClient(client);
        accident.setInsurance(insurance.get());
        em.persist(accident);
    }
    //client 사고리스트 가져오기
    public ArrayList<Accident> getMyAccident(int clientIdx) {
        ArrayList<Accident> accidentArrayList = findAllAccident();
        ArrayList<Accident> accidents = new ArrayList<Accident>();
        for(int i=0; i< accidentArrayList.size(); i++){
            if(accidentArrayList.get(i).getClient().getClientIdx() == clientIdx){
                accidents.add(accidentArrayList.get(i));
            }
        }
        return accidents;
    }
    //handler 사고리스트 가져오기
    public ArrayList<Accident> getAccidentList() {
        ArrayList<Accident> accidentArrayList = findAllAccident();
        ArrayList<Accident> accidents = new ArrayList<Accident>();
        for(int i=0; i< accidentArrayList.size(); i++){
            if(accidentArrayList.get(i).getEmployee() == null){
                accidents.add(accidentArrayList.get(i));
            }
        }
        return accidents;
    }
    //handler 사고승인
    public int finishAccident(AccidentForm accidentForm) {
        Accident accident = findAccidentOne(accidentForm.getAccidentIdx());
        Employee employee = findEmployeeOne(accidentForm.getEmployeeIdx());
        accident.setEmployee(employee);
        accident.setMeasuredPrice(accidentForm.getMeasuredPrice());
        return accident.getAccidentIdx();
    }



    public Optional<Insurance> findByType(String insuranceType){
        return findInsuranceAll().stream().filter(
                        i -> i.getDecriminatorValue().equals(insuranceType))
                .findFirst();
    }
    private List<Insurance> findInsuranceAll() {
        return em.createQuery("select i from Insurance i", Insurance.class).getResultList();
    }
    public Client findOne(int idx) {
        return em.find(Client.class, idx);
    }

    public ArrayList<Accident> findAllAccident() {
        return (ArrayList<Accident>) em.createQuery("select c from Accident c", Accident.class).getResultList();
    }

    public Accident getAccident(int accidentIdx) {
        Accident accident = findAccidentOne(accidentIdx);
        return accident;
    }

    private Employee findEmployeeOne(int employeeIdx) {
        return em.find(Employee.class, employeeIdx);
    }

    public Accident findAccidentOne(int accidentIdx) {
        return em.find(Accident.class, accidentIdx);
    }



}
