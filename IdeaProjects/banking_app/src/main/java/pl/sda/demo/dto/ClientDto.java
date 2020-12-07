package pl.sda.demo.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private Integer age;
    private Integer children;

    private Boolean hasCreditCard;
    private Boolean hasDebitCard;

    private Long incomeBrutto;
    private Long incomeNetto;
    private Boolean hasLongTermJob;
    private Boolean hasOwnBusiness;
    private Boolean isLumpSum;
    private Boolean hasCLContract;
    private Boolean hasCard;
}
