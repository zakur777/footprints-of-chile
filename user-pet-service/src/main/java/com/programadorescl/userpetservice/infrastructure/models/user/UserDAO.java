package com.programadorescl.userpetservice.infrastructure.models.user;

import com.programadorescl.userpetservice.application.domains.valueobjects.user.Rut;
import com.programadorescl.userpetservice.infrastructure.models.BaseDAO;
import com.programadorescl.userpetservice.infrastructure.models.pet.PetDAO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

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
