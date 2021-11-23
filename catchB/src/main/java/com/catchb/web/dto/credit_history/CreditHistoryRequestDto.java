package com.catchb.web.dto.credit_history;

import com.catchb.domain.credit_history.CreditHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreditHistoryRequestDto {
    private String credit_date;
    private String credit_name;
    private String credit_give_take;

    @Builder
    public CreditHistoryRequestDto(String credit_date, String credit_name, String credit_give_take){
        this.credit_date = credit_date;
        this.credit_name = credit_name;
        this.credit_give_take = credit_give_take;
    }
    public CreditHistory toEntity() {
        return CreditHistory.builder()
                .credit_date(credit_date)
                .credit_name(credit_name)
                .credit_give_take(credit_give_take)
                .build();
    }
}
