package com.catchb.domain.credit_history;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Component

public class CreditHistory {
    @Id // 크레딧 내역 번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long credit_num;

    // 크레딧 날짜내역
    @Column(columnDefinition = "DATE", nullable = false)
    private String credit_date;

    // 크레딧 사용내역
    @Column(nullable = false)
    private String credit_name;

    // 크레딧 주고받은 내역
    @Column(nullable = false)
    private String credit_give_take;

    @Builder
    public CreditHistory(String credit_date, String credit_name, String credit_give_take){
        this.credit_date = credit_date;
        this.credit_name = credit_name;
        this.credit_give_take = credit_give_take;
    }

}