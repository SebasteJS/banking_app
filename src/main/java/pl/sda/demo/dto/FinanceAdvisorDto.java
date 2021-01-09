package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinanceAdvisorDto {

    private Long id;



    @NotEmpty
    private String lastName;

    @NotEmpty
    @Size(min = 5, message = "login must be at least 9 characters long")
    private String login;

    @NotEmpty
    @Size(min = 5, message = "password must be at least 9 characters long")
    private String firstName;


    private String password;
}
