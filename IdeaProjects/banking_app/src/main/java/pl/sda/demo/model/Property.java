package pl.sda.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private double price;

    // albo rynek wtórny albo pierwotny

    @Column
    private boolean isPrimaryMarket;

    // albo własność albo spółdzielcze własnościowe
    @Column
    private String isOwnership;


    // albo mieszkanie albo dom
    @Column
    private String isFlat;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}