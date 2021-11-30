package com.example.demo.Controller;

import com.example.demo.Form.AccidentForm;
import com.example.demo.Service.Accident.AccidentListImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ClientController {
    private final AccidentListImpl accidentListService;

    @PostMapping("/addAccident")
    public String addAccident(@RequestBody AccidentForm accident){
        accidentListService.addAccident(accident);
        return "성공";
    }
}
