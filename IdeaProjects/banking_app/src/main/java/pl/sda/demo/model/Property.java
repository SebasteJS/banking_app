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
    private boolean isSecondaryMarket;
    @Column
    private boolean isPrimaryMarket;

    // albo własność albo spółdzielcze własnościowe
    @Column
    private boolean isOwnership;
    @Column
    private boolean isCooperativeOwnership;

    // albo mieszkanie albo dom
    @Column
    private boolean isFlat;
    @Column
    private boolean isHouse;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}