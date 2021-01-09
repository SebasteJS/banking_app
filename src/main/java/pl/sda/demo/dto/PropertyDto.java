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

    private boolean isPrimaryMarket; // rynek wtórny albo pierwotny

    private String isOwnership; // własność albo spółdzielcze własnościowe

    private String isFlat;  // mieszkanie albo dom

}
