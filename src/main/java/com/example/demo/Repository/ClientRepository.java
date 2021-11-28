package com.example.demo.Repository;

import com.example.demo.Domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor // final이 붙어있으면 constructor을 안 만들어도 됨.
public class ClientRepository {
    private final EntityManager em;

    //Client 저장
    public void postClient(Client client){
        em.persist(client);
    }


}
