package pl.sda.demo.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
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
