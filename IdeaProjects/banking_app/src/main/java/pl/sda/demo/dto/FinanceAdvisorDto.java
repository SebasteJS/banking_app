package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinanceAdvisorDto {

    private Long id;

    private String firstName;

    private String lastName;

    @Size(min = 5, message = "login must be at least 9 characters long")
    private String login;

    @Size(min = 5, message = "password must be at least 9 characters long")
    private String password;
}
