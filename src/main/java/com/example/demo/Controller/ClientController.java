package com.example.demo.Controller;

import com.example.demo.Form.AccidentForm;
import com.example.demo.Service.Accident.AccidentListImpl;
import com.example.demo.Service.Contract.ContractListImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        String suggestion = contractListService.getSuggestion(clientIdx);
        System.out.println(suggestion);
        return suggestion;
    }
    @GetMapping("/subscription")
    public String getSubscription(@RequestParam("clientIdx")int clientIdx){
        String subscription = contractListService.getSubscription(clientIdx);
        System.out.println(subscription);
        return subscription;
    }
}
