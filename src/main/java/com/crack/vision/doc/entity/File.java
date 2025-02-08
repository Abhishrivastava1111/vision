package com.crack.vision.doc.entity;

import com.crack.vision.common.entity.SuperEntity;
import com.crack.vision.user.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "docs")
@Data
@EqualsAndHashCode(callSuper = false)

public class File extends SuperEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "file", columnDefinition = "TEXT")
    private String file;

    @Column(name = "type")
    private String type;

    @OneToOne
    private User uploadedBy;

    @Column(name="user_Id")
    private Integer userId;

}
