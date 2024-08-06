package com.netas.coop.FlexibleHours.entities;

import java.util.*;
import jakarta.persistence.*;
import lombok.Data;
import com.netas.coop.FlexibleHours.enums.Role;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String fullName;

    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "management_id")
    private Management management;

    @OneToMany(mappedBy = "user")
    private List<Permission> permissions;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> authorities;
}
