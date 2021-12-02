package com.example.demo.Controller;

import com.example.demo.Domain.Accident;
import com.example.demo.Form.AccidentForm;
import com.example.demo.Service.Accident.AccidentListImpl;
import com.example.demo.Service.Contract.ContractListImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/client")
public class ClientController {
    private final AccidentListImpl accidentListService;
    private final ContractListImpl contractListService;

    @PostMapping("/addAccident")
    public String addAccident(@RequestBody AccidentForm accident){
        accidentListService.addAccident(accident);
        return "성공";
    }

    @GetMapping("/suggestion")
    public String getSuggestion(@RequestParam("clientIdx")int clientIdx){
        String suggestion = contractListService.getSuggestion(clientIdx);;
        return suggestion;
    }
    @GetMapping("/subscription")
    public String getSubscription(@RequestParam("clientIdx")int clientIdx){
        String subscription = contractListService.getSubscription(clientIdx);
        return subscription;
    }
    @GetMapping("/accidentList")
    public ArrayList<Accident> getMyAccidentList(@RequestParam("clientIdx")int clientIdx){
        return accidentListService.getMyAccident(clientIdx);
    }
    @PostMapping("/addLawsuit")
    public int addLawsuit(@RequestBody AccidentForm accidentForm){
        return accidentListService.addLawsuit(accidentForm);
    }
}
