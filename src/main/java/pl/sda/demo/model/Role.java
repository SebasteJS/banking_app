package pl.sda.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.demo.model.type.RoleType;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Role")
public class Role {

    public Role(RoleType roleType){
        type = roleType;
    }

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long id;

    @Column(name = "typ_roli")  //TODO przerobić nazwa po angielsku
    @Enumerated(EnumType.STRING)
    private RoleType type;

    @Override
    public String toString() {
        return "" + type ;
    }
}
