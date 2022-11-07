package com.programadorescl.userpetservice.infrastructure.models.pet;

import com.programadorescl.userpetservice.infrastructure.models.BaseDAO;
import com.programadorescl.userpetservice.infrastructure.models.user.UserDAO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "pets")
public class PetDAO extends BaseDAO {

    @Id
    @Column(length = 50)
    private String name;

    @Column(name = "is_active", columnDefinition = "default bit 1")
    private boolean activeTreatment;

    private String breed;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserDAO user;

}
