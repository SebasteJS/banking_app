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
    @Column(name = "customer_id")
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

//    @Column
//    private CustomerIncome customerIncome;
//    @ManyToOne
//    private User financeAdvisor;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Credit credit;

//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//    private Property property;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "property_id")
    private Property property;


    @OneToOne(cascade = CascadeType.MERGE)
//    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "customerIncome_id")
    private CustomerIncome customerIncome;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerLiabilities customerLiabilities;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Broker broker;

    @OneToMany
    @JoinColumn(name = "notes_id", referencedColumnName = "customer_id")
    private List<Notes> notes;

    @ManyToOne
    @JoinTable(name = "user_to_customer",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private User user;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    //    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "credit_id", referencedColumnName = "id")
//    private Credit credit;
}

