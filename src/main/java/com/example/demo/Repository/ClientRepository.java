package com.example.demo.Repository;

import com.example.demo.Domain.Accident;
import com.example.demo.Domain.Client;
import com.example.demo.Domain.Insurance.Insurance;
import com.example.demo.Form.AccidentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor // final이 붙어있으면 constructor을 안 만들어도 됨.
public class ClientRepository {
    private final EntityManager em;

    //Client 저장
    public void postClient(Client client){
        em.persist(client);
    }
    //로그인 로직
    public Optional<Client> findByLoginId(String loginId){
        //findAll().stream() 루프를 돌면서 찾는다
        return findAll().stream().filter(
                c -> c.getId().equals(loginId))
                .findFirst();
    }
    private List<Client> findAll() {
        return em.createQuery("select c from Client c", Client.class).getResultList();
    }
    public Client findOne(int idx) {
        return em.find(Client.class, idx);
    }

    //사고 접수 로직
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
    private List<Insurance> findInsuranceAll() {
        return em.createQuery("select i from Insurance i", Insurance.class).getResultList();
    }
    public Optional<Insurance> findByType(String insuranceType){
        return findInsuranceAll().stream().filter(
                        i -> i.getDecriminatorValue().equals(insuranceType))
                .findFirst();
    }
}