package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.demo.model.CustomerIncome;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerIncomeDto {

    private Long id;

    @NotNull
    private double netIncome;

    @NotEmpty
    private boolean isContractOfEmployment;

    @NotEmpty
    private boolean isIndefiniteContract;

    @NotEmpty
    private boolean isSelfEmployed;     // if true wtedy czy kpir, karta, ryczałt

    @NotEmpty
    private String formOfSettlement;    //albo kpir, ryczalt karta podatkowa

//    @NotEmpty
//    private CustomerIncome customerIncome;
}

