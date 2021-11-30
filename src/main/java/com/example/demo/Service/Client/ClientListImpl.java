package com.example.demo.Service.Client;


import com.example.demo.Domain.Client;
import com.example.demo.Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true) // data 변경하는 부분 이노테이션
public class ClientListImpl implements ClientList {
    private ClientRepository clientRepository;

    @Transactional
    @Override
    public String signUp(Client client) {
        clientRepository.postClient(client);
        return null;
    }
    @Override
    public Client signIn(String id, String pw) {
        return clientRepository.findByLoginId(id)
                .filter(c -> c.getPw().equals(pw))
                .orElse(null);
    }
}
