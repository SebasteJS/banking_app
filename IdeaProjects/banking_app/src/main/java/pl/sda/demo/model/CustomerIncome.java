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
    private boolean isIndefiniteContract;

    @Column
    private boolean isSelfEmployed;
    // if true wtedy czy kpir, karta, ryczałt

    //albo kpir, ryczalt karta podatkowa
    @Column
    private boolean isKpir;
    @Column
    private boolean isRyczalt;
    @Column
    private boolean isKartaPodatkowa;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
