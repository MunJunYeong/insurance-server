package com.example.demo.Domain.Insurance;

import com.example.demo.Domain.Employee;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Data
@Setter
@Inheritance(strategy = InheritanceType.JOINED) // join방식으로 상속을 매핑한다.
@DiscriminatorColumn // 하위 테이블의 구분 컬럼 생성(default = DTYPE)
public abstract class Insurance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int insuranceIdx;
    private String restriction;
    private Date period;
    private int fee;
    private String guaranteedContent;
    private int rate;
    private int maximumReward;

    @ManyToOne
    @JoinColumn(name = "employeeIdx")
    private Employee employeeIdx;

//    @OneToMany
//    private List<Contract> insuranceContract;
//    @OneToMany
//    private List<Accident> insuranceAccident;
}

