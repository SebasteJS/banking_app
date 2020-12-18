package pl.sda.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {

    private String firstName;
    private String lastName;
    private String companyName;
    private String login;
    private String password;
}
