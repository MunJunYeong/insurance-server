package insurance.Service.Accident;

import insurance.Domain.Accident;
import insurance.Form.AccidentForm;

import java.util.ArrayList;

public interface AccidentList {
    public boolean addAccident(AccidentForm accident);
    public ArrayList<Accident> getMyAccident(int clientIdx);
    public int addLawsuit(AccidentForm accidentForm);


    public ArrayList<Accident> select();
    public boolean delete(int accidentId);
    public Accident search(int accidentId);
    public boolean update(String TypeName, String Content, int index);
    public boolean update(String TypeName, int Content, int index);
    public int ShowSize();
    public String getAccidentList(int i);



}
