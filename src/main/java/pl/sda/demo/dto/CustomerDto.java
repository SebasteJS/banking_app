package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
//    @Size(min = 9, message = "phone no. must be at least 9 digits long")
    private String phone;

    @NotEmpty
    @Email
    private String email;

//    @NotEmpty
    @Min(16)
    @Max(80)
    private int age;

//    @NotEmpty
    @Min(0)
    private int kids;

    @NotEmpty
    private String customerStatus;

}
