package com.catchb.web.dto.credit_history;

import com.catchb.domain.credit_history.CreditHistory;
import lombok.Getter;

@Getter
public class CreditHistoryResponseDto {
    private Long credit_num;
    private String credit_date;
    private String credit_name;
    private String credit_give_take;

    public CreditHistoryResponseDto(CreditHistory entitiy){
        this.credit_num = entitiy.getCredit_num();
        this.credit_date = entitiy.getCredit_date();
        this.credit_name = entitiy.getCredit_name();
        this.credit_give_take = entitiy.getCredit_give_take();
    }
}
