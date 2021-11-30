package com.example.demo.Controller;

import com.example.demo.Domain.Accident;
import com.example.demo.Service.Accident.AccidentListImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/accident")
@RequiredArgsConstructor
public class AccidentController {

    AccidentListImpl accidentList;
    ArrayList<Claim> ClaimList = new ArrayList<Claim>();


    @PostMapping("/handling")
    public String Handling(@RequestParam int index ,@RequestParam int calculatedInsuranceFee) {
        accidentList.update("calculatedInsuranceFee",calculatedInsuranceFee,index);
        //지우기
        return "사고처리완료";
    }

    @PostMapping("/report")
    public String report(@RequestParam Accident accident) {
//        accidentList.addAccident(accident);
        return "사고신고완료";
    }

    @PostMapping("/claim")
    public String Claim(@RequestParam int index, @RequestParam String reason) {
//        Claim claim = new Claim(accidentList.search(index).getAccidentIdx(), reason);
//        ClaimList.add(claim);
        return "소송완료";
    }
    @GetMapping("/accident")
    public String getAccidentList() {
        String List = "";
        for(int i = 0 ; i<accidentList.ShowSize();i++) {
            List += accidentList.getAccidentList(i)+"\n";
        }
        return List;
    }
//    @PostMapping("/GetAccident2")
//    public ArrayList<Accident> getAccident2() {
//        return accidentList.select();
//    }

//    @PostMapping("/GetImage")
//    public Image getImage(int index) {
//        return accidentList.search(index).getImage();
//    }






}

class Claim{
    int AccidentId;
    String reason;

    public Claim(int accidentIdx, String reason) {

        this.AccidentId = accidentIdx;
        this.reason = reason;
    }

}

