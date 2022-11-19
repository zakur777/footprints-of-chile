package com.programadorescl.userpetservice.infrastructure.models.pet;

import com.programadorescl.userpetservice.infrastructure.models.BaseDAO;
import com.programadorescl.userpetservice.infrastructure.models.user.UserDAO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
