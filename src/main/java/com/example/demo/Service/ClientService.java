package com.example.demo.Service;

import com.example.demo.Domain.Client;
import com.example.demo.Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class ClientService {
    private final ClientRepository clientRepository;

    @Transactional
    public Long signUp(Client client){
        clientRepository.postClient(client);
        return client.getClientIdx();
    }

}