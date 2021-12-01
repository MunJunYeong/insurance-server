package com.example.demo.Repository;

import com.example.demo.Domain.Accident;
import com.example.demo.Domain.Employee;
import com.example.demo.Form.AccidentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
@Repository
@RequiredArgsConstructor
public class AccidentRepository {
    private final EntityManager em;

    public ArrayList<Accident> getAccidentList() {
        ArrayList<Accident> accidentArrayList = findAllContract();
        ArrayList<Accident> accidents = new ArrayList<Accident>();
        for(int i=0; i< accidentArrayList.size(); i++){
            if(accidentArrayList.get(i).getEmployee() == null){
                accidents.add(accidentArrayList.get(i));
            }
        }
        return accidents;
    }
    public ArrayList<Accident> findAllContract() {
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

    public int finishAccident(AccidentForm accidentForm) {
        Accident accident = findAccidentOne(accidentForm.getAccidentIdx());
        Employee employee = findEmployeeOne(accidentForm.getEmployeeIdx());
        accident.setEmployee(employee);
        accident.setMeasuredPrice(accidentForm.getMeasuredPrice());
        return accident.getAccidentIdx();
    }
}
