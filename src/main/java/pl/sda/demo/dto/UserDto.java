package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.demo.model.Customer;
import pl.sda.demo.model.Role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class UserDto implements Serializable {

    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Size(min = 4, message = "login must be at least 4 characters long")
    private String login;

    @NotEmpty
    @Size(min = 6, message = "password must be at least 6 characters long")
    private String password;

    @NotEmpty
    private List<Role> roles;

    private List<Customer> customers;

}
