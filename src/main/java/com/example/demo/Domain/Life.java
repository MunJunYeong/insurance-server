package com.example.demo.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Data
@DiscriminatorValue("Life")
public class Life extends Insurance {
    private int healthGrade;

}