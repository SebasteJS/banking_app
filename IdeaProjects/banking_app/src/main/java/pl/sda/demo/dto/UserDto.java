package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.demo.model.Role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Serializable {

    private Long id;

    @NotEmpty
    private String first_name;

    @NotEmpty
    private String last_name;

    @NotEmpty
    @Size(min = 4, message = "login must be at least 4 characters long")
    private String login;

    @NotEmpty
    @Size(min = 6, message = "password must be at least 6 characters long")
    private String password;

    private List<Role> roles;
}
