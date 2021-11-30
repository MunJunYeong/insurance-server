package com.example.demo.Form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuggestionForm {
    private int EmployeeIdx;
    private int ClientIdx;
    private String content;
    private String insuranceType;
}
