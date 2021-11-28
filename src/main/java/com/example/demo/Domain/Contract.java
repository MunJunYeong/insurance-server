package com.example.demo.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long contractIdx;

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
