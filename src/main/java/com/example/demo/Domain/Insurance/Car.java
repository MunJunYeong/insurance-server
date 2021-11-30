package com.example.demo.Domain.Insurance;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Data
@DiscriminatorValue("Car")
public class Car extends Insurance {
    private int carNO;
    private int accidentCount;
    private int maxReward;
}
