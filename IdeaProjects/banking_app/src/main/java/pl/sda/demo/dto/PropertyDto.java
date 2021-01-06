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
public class PropertyDto {
    private Long id;

    @NotEmpty
    private double price;

    // albo rynek wtórny albo pierwotny

    private boolean isPrimaryMarket;

    // albo własność albo spółdzielcze własnościowe
    private boolean isOwnership;

    // albo mieszkanie albo dom

    private boolean isFlat;

}
