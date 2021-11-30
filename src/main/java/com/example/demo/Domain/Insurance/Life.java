package com.example.demo.Domain.Insurance;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Data
@DiscriminatorValue("Life")
public class Life extends Insurance {
    private int healthGrade;

}