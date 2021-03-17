package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyDto {
    private Long id;

    @NotEmpty
    private double price;

    @NotEmpty
    private String marketOfTransaction; // rynek wtórny albo pierwotny

    private String ownership; // własność albo spółdzielcze własnościowe

    private String isFlat;  // mieszkanie albo dom

}
