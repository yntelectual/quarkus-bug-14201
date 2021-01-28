package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
//@EntityListeners(TraceAbleListener.class)
@Data
public class Customer extends BaseEntity {

    @Version
    @Column(name = "version")
    private int version;

    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private User user;


}