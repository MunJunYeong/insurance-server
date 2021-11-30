package com.example.demo.Domain.Insurance;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Data
@DiscriminatorValue("Fire")
public class Fire extends Insurance {
    private int buildingPrice;
    private int buildingCount;
}
