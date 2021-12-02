package com.example.demo.Service.Accident;

import com.example.demo.Domain.Accident;
import com.example.demo.Form.AccidentForm;

import java.util.ArrayList;

public interface AccidentList {
    public boolean addAccident(AccidentForm accident);
    public ArrayList<Accident> getMyAccident(int clientIdx);



    public ArrayList<Accident> select();
    public boolean delete(int accidentId);
    public Accident search(int accidentId);
    public boolean update(String TypeName, String Content, int index);
    public boolean update(String TypeName, int Content, int index);
    public int ShowSize();
    public String getAccidentList(int i);


}
