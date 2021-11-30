package com.example.demo.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
public class Accident {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long accidentIdx;
    private String content;
    private Date date;
    private int damagePrice;
    private int measuredPrice;

//    @ManyToOne
//    @JoinColumn(name = "clientIdx")
//    private Client clientIdx;
//
//    @ManyToOne
//    @JoinColumn(name = "employeeIdx")
//    private Employee employeeIdx;
//
//    @ManyToOne
//    @JoinColumn(name = "insuranceIdx")
//    private Insurance insuranceIdx;
}
