package com.programadorescl.userpetservice.infrastructure.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseDAO {

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    @CreationTimestamp
    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    @UpdateTimestamp
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @Builder.Default private String status = "1";
}
