package com.example.demo.Service.Insurance;

import com.example.demo.Domain.Insurance.Insurance;

import java.util.ArrayList;

public interface InsuranceList {
    public ArrayList<Insurance> select();
    public boolean add(Insurance insurance);
    public boolean delete(int index);
    public Insurance search(int insurance_id);
    public boolean update(String TypeName, String Content, int index);
    public boolean update(String TypeName, int rate, int index);

    //새거는 여기서부터 시작

}