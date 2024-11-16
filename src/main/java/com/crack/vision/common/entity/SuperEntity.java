package com.crack.vision.common.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@MappedSuperclass
public class SuperEntity {

    @Id
    @SequenceGenerator(name = "EntitySequence", initialValue = 600)
    @GeneratedValue(generator = "EntitySequence", strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "updated_at")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Column(name = "created_at")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Where(clause = "is_deleted = false")
    @Column(columnDefinition = "boolean default false", name = "is_deleted")
    private Boolean isDeleted;

}
