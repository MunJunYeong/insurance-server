package com.example.demo.Service.Insurance;


import com.example.demo.Domain.Insurance.Insurance;
import com.example.demo.Repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
@Transactional // data 변경하는 부분 이노테이션
public class InsuranceListImpl implements InsuranceList {

    private final ArrayList<Insurance> insuranceList;

    private final InsuranceRepository insuranceRepository;

    @Override
    public ArrayList<Insurance> select() {
        return insuranceList;
    }

    public boolean add(Insurance insurance) {
        this.insuranceList.add(insurance);
        return true;
    }

    public boolean delete(int index) {
        this.insuranceList.remove(index);
        return true;
    }

    public int ShowSize() {
        return this.insuranceList.size();
    }

    public Insurance search(int insuranceId) {
        return insuranceList.get(insuranceId);
    }

    public boolean update(String TypeName, String Content, int index) {
        switch (TypeName) {
            case "maximumReward":
//                insuranceList.get(index).setMaximumReward(Content);
                return true;

            case "restriction":
                insuranceList.get(index).setRestriction(Content);
                return true;
            case "insurancePeriod":
//                insuranceList.get(index).setPeriod(Content);
                return true;
            case "guaranteedContent":
                insuranceList.get(index).setGuaranteedContent(Content);
                return true;
            case "insuranceType":
//                insuranceList.get(index).setInsuranceType(Content);
        }
        return true;
    }

    public boolean update(String TypeName, int Content, int index) {
        switch (TypeName) {
            case"customerId":
//                insuranceList.get(index).setCustomerId(index);
                return true;

            case "insuranceId":
                insuranceList.get(index).setInsuranceIdx(Content);
                return true;
            case "insuranceFee":
                insuranceList.get(index).setFee(Content);
                return true;

            case "rate":
                insuranceList.get(index).setRate(Content);
                return true;

        }
        return true;
    }
}