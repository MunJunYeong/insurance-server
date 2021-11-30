package com.example.demo.Controller;

import com.example.demo.Domain.Insurance.Car;
import com.example.demo.Domain.Insurance.Fire;
import com.example.demo.Domain.Insurance.Industrial;
import com.example.demo.Domain.Insurance.Life;
import com.example.demo.Service.Insurance.InsuranceListImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Insurance")
public class InsuranceController {

//    InsuranceDesign insuranceDesign = new InsuranceDesign();
    InsuranceListImpl insuranceList;

    @PostMapping("/MakeInsurance/Fire")
    public String FireInsuracnce(@RequestParam Fire fire ) {
//        insuranceList.add(insuranceDesign.createInsurance(fire));
        return "보험생성완료";
    }

    @PostMapping("/MakeInsurance/Car")
    public String CarInsuracnce(@RequestParam Car car ) {
//        insuranceList.add(insuranceDesign.createInsurance(car));
        return "보험생성완료";
    }

    @PostMapping("/MakeInsurance/Life")
    public String LifeInsuracnce(@RequestParam Life life ) {
//        insuranceList.add(insuranceDesign.createInsurance(life));
        return "보험생성완료";
    }

    @PostMapping("/MakeInsurance/IndustrialAccident")
    public String IndustrialAccidentInsuracnce(@RequestParam Industrial industrialAccident ) {
//        insuranceList.add(insuranceDesign.createInsurance(industrialAccident));
        return "보험생성완료";
    }




}
