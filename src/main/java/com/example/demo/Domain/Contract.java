package com.example.demo.Domain;

import com.example.demo.Domain.Insurance.Insurance;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int contractIdx;

    private String suggestion;
    private String subscription;
    private Date created;
    private Boolean checkForm;
    private Boolean checkMoney;

    @ManyToOne
    @JoinColumn(name = "clientIdx")
    private Client clientIdx;

    @ManyToOne
    @JoinColumn(name = "employeeIdx")
    private Employee employeeIdx;

    @ManyToOne
    @JoinColumn(name = "insuranceIdx")
    private Insurance insuranceIdx;
}
