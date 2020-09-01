package com.belajar.mocking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    private Date createdDate;
    private Date updatedDate;

    @PrePersist
    private void prePersist() {
        setCreatedDate(new Timestamp(System.currentTimeMillis()));
        setUpdatedDate(new Timestamp(System.currentTimeMillis()));
    }

    @PreUpdate
    private void preUpdate() {
        setUpdatedDate(new Timestamp(System.currentTimeMillis()));
    }
}
