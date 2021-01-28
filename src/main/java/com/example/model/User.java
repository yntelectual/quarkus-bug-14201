package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "appuser")
@Getter
@Setter
public class User extends BaseEntity {

    @Column(length = 255, unique = true, nullable = false)
    @NotNull
    @Size(max = 255)
    private String email;

    //SPOOKY if you remove this relationship, then the select will not fail
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_in_role", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
    private Set<Role> roles = new HashSet<>();

}
