package com.example.demo.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Data
@DiscriminatorValue("Industrial")
public class Industrial extends Insurance {
    private String workplaceAddress;
    private int businessNo;
    private String workplacePosition;
    private int safeGrade;
    private String workplaceType;
}