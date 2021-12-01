package com.example.demo.Repository;

import com.example.demo.Domain.Accident;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
@Repository
@RequiredArgsConstructor
public class AccidentRepository {
    private final EntityManager em;

    public ArrayList<Accident> getAccident() {
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
}
