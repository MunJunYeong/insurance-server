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
    private Boolean checkForm = false;
    private Boolean checkMoney = false;

    @ManyToOne
    @JoinColumn(name = "clientIdx")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "employeeIdx")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "insuranceIdx")
    private Insurance insurance;
}
