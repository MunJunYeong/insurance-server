package com.example.demo.Domain.Insurance;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Data
@DiscriminatorValue("car")
public class Car extends Insurance {
    private Integer carNO;
    private Integer accidentCount;
    private Integer maxReward;
}
