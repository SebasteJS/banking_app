package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Size(min = 9, message = "phone no. must be at least 9 digits long")
    private String phone;

    @NotEmpty
    private String email;

    @NotEmpty
    @Min(16)
    @Max(80)
    private int age;

    @NotEmpty
    @Min(0)
    private int kids;

    // 1
    private boolean isProspect;
    // 2
    private boolean isCreditApplicationSubmitted;
    // 3
    private boolean isCreditFinshed;
    // 4
    private boolean isInactive;

}
