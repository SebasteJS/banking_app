package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditDto {

    private Long id;

    @NotEmpty
    private double loanAmmount;

    @NotEmpty
    @Min(5)
    @Max(30)
    private int creditPeriod;
}
