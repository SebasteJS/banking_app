package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerIncomeDto {

    private Long id;

    @NotEmpty
    private double netIncome;

    @NotEmpty
    private boolean isIndefiniteContract;

    @NotEmpty
    private boolean isSelfEmployed;
    // if true wtedy czy kpir, karta, ryczałt

    //albo kpir, ryczalt karta podatkowa
    @NotEmpty
    private boolean isKpir;
    @NotEmpty
    private boolean isRyczalt;
    @NotEmpty
    private boolean isKartaPodatkowa;
}
