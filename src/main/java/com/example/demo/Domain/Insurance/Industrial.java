package com.example.demo.Domain.Insurance;

import com.example.demo.Domain.Insurance.Insurance;
import lombok.Data;
import lombok.Getter;

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