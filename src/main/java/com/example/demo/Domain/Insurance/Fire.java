package com.example.demo.Domain.Insurance;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Data
@DiscriminatorValue("fire")
public class Fire extends Insurance {
    private Integer buildingPrice;
    private Integer buildingCount;
}
