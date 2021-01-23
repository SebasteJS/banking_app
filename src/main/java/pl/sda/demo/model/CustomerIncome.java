package pl.sda.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer_income")
public class CustomerIncome {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private double netIncome;

    @Column
    private boolean isContractOfEmployment; //

    @Column
    private boolean isIndefiniteContract; //

    @Column
    private boolean isSelfEmployed; // if true wtedy czy kpir, karta, ryczałt

    @Column
    private String formOfSettlement; //kpir, ryczalt karta podatkowa

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}

