package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinanceAdvisorDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String login;

    private String password;
}
