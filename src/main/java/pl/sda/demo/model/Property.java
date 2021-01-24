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
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private double price;

    @Column
    private boolean isPrimaryMarket; //rynek wtórny albo pierwotny

    @Column
    private String isOwnership; //własność albo spółdzielcze własnościowe

    @Column
    private String isFlat; //mieszkanie albo dom //TODO przerobić na enum

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
}
