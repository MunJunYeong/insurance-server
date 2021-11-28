package com.example.demo.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Data
@Inheritance(strategy = InheritanceType.JOINED) // join방식으로 상속을 매핑한다.
public abstract class Insurance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long insuranceIdx;
    private String restriction;
    private Date period;
    private int fee;
    private String guaranteedContent;
    private int rate;
}

