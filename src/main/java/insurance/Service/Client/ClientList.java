package insurance.Service.Client;

import insurance.Domain.Client;

public interface ClientList {
    public String signUp(Client client);
    public Client signIn(String id, String pw);
    // employee = salesman 이 가져올 때 사용
    //find ID
    public Client findId(String name, String email);
    public Client findPw(String id, String email);

    Boolean checkId(String id);
}
