package com.programadorescl.userpetservice.infrastructure.models.user;

import com.programadorescl.userpetservice.infrastructure.models.BaseDAO;
import com.programadorescl.userpetservice.infrastructure.models.pet.PetDAO;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class UserDAO extends BaseDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String rut;

    private String name;

    private String address;

    private String city;

    private String phone;

    @OneToMany(mappedBy = "user")
    @Column(insertable = false, updatable = false)
    private List<PetDAO> pets;
}
