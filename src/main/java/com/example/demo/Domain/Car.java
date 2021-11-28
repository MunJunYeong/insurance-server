package com.example.demo.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
