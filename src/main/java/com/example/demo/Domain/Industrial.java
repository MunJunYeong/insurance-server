package com.example.demo.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Data
public class Industrial {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator = "USER_SEQ_GEN" //식별자 생성기를 설정해놓은  USER_SEQ_GEN으로 설정
    )
    private Long insuranceIdx;
    private String workplaceAddress;
    private int businessNo;
    private String workplacePosition;
    private int safeGrade;
    private String workplaceType;
}