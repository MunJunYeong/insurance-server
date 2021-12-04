package insurance.Service.Client;


import insurance.Domain.Client;
import insurance.Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true) // data 변경하는 부분 이노테이션
public class ClientListImpl implements ClientList {
    private final ClientRepository clientRepository;

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

    @Override
    public ArrayList<Client> select() {
        return null;
    }


    @Override
    public boolean delete(int customerId) {
        return false;
    }

    @Override
    public Client getClientData(int customerId) {
        return null;
    }

    @Override
    public boolean update(String TypeName, String Content, int index) {
        return false;
    }

    @Override
    public boolean update(String TypeName, int Content, int index) {
        return false;
    }

    @Override
    public int ShowSize() {
        return 0;
    }

    @Override
    public String getCustomerList(int i) {
        return null;
    }
}
