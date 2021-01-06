package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLiabilitiesDto {

    private Long id;

    @NotEmpty
    private double creditCards;

    @NotEmpty
    private double accountDebt;

    @NotEmpty
    private double childSupport;
}
