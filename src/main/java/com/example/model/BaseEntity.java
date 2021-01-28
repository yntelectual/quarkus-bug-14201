package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Id
    private Long id;

    //SPOOKY if you remove this date field, then the select will not fail
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;


}