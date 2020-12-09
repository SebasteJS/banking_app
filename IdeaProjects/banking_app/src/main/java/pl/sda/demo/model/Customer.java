package pl.sda.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "kids")
    private int kids;

    @ManyToOne
    private FinanceAdvisor financeAdvisor;

    @OneToOne(mappedBy = "customer")
    private Credit credit;

    @OneToOne(mappedBy = "customer")
    private Property property;

    @OneToOne(mappedBy = "customer")
    private CustomerIncome customerIncome;

    @OneToOne(mappedBy = "customer")
    private CustomerLiabilities customerLiabilities;

    @OneToOne(mappedBy = "customer")
    private Broker broker;





//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "credit_id", referencedColumnName = "id")
//    private Credit credit;
}

