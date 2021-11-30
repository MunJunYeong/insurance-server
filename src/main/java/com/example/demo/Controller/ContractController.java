package com.example.demo.Controller;

import com.example.demo.Service.Contract.ContractListImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contract")
public class ContractController {

    ContractListImpl contractList;

    //분납수금
    @PostMapping("/payCollection")
    public String PayCollection(@RequestParam int index) {
        return "처리완료";
    }

    //만기계약
    @PostMapping("/expiration")
    public String Expiration(@RequestParam int index) {
        return "처리완료";
    }

    //인수검사
    @PostMapping("/testing")
    public String setTesting(@RequestParam int index,@RequestParam boolean test ) {

        contractList.update("Testing",test,index);
        return "인수검사 완료";
    }

    @GetMapping("/")
    public String getContractList() {
        String List = "";
        for(int i = 0 ; i<contractList.ShowSize();i++) {
            List += contractList.getContractList(i)+"\n";
        }
        return List;
    }

//    @PostMapping("/GetContract2")
//    public ArrayList<Contract> getContract2() {
//        return contractList.select();
//    }

    //Only Success Contract
    public String getSuccessContractList() {
        String List = "";
//        for(int i = 0 ; i<contractList.ShowSize();i++) {
//            if(contractList.search(i).getFinal()==true){
//            List += contractList.getContractList(i)+"\n";
//        }}
        return List;
    }

    //제안서
    @PostMapping("/writeProposal")
    public String WriteProposal(@RequestParam String content ) {
//        ContractService.WriteProposal(content);
        return "제안서 작성 완료";
    }



    //청약서
    @PostMapping("/WriteApplicationForm")
    public String WriteApplicationForm(@RequestParam String content ,@RequestParam String insuranceType) {
//        contractList.add(ContractService.WriteApplicationForm(content,insuranceType));
        return "청약서 작성 완료";
    }
    //제안서확인
    @GetMapping("/proposal")
    public String ShowProposal(@RequestParam int index ) {
//        return contractList.search(index).getProposal();
        return "";
    }

    //청약서확인
    @GetMapping("/applicationForm")
    public String ShowApplicationForm(@RequestParam int index ) {
//        return contractList.search(index).getApplicationForm();
        return "";
    }

    //입금확인
    @GetMapping("/checkMoney")
    public String CheckMoney(@RequestParam boolean check,@RequestParam int index ) {
        contractList.search(index).setCheckMoney(check);
        return "입금 확인 완료";
    }

    //최종계약
    @PostMapping("/finalContract")
    public String FinalContract(@RequestParam boolean check ) {
//        if(ContractService.FinalContract(check)){
//            return "최종 계약 완료";
//        }
        return "최종 계약 실패";
    }
}
