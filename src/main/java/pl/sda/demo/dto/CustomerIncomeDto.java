package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerIncomeDto {

    private Long id;

    @NotEmpty
    private double netIncome;

    @NotEmpty
    private boolean isIndefiniteContract;

    @NotEmpty
    private boolean isSelfEmployed;     // if true wtedy czy kpir, karta, ryczałt

    @NotEmpty
    private String formOfSettlement;    //albo kpir, ryczalt karta podatkowa
}

