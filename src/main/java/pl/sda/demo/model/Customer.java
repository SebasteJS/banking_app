package pl.sda.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(name = "customer_status")
    private String customerStatus; //status klienta - 1. prospect, 2. złożont wniosek; //TODO przerobić na enum

    @ManyToOne
    private User financeAdvisor;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Credit credit;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Property property;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerIncome customerIncome;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerLiabilities customerLiabilities;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Broker broker;

    @OneToMany
    @JoinColumn(name = "notes_id", referencedColumnName = "id")
    private List<Notes> notes;






//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "credit_id", referencedColumnName = "id")
//    private Credit credit;
}

