package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDto implements Serializable {

    private String firstName;
    private String lastName;
    private String companyName;
    private String login;
    private String password;
}
