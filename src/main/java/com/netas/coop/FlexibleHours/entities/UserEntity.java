package com.netas.coop.FlexibleHours.entities;

import jakarta.persistence.*;
import lombok.Data;

import javax.management.relation.Role;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;

    private String email;

    private String registrationNumber;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentEntity;

    @ManyToOne
    @JoinColumn(name = "management_id")
    private UnitEntity unitEntity;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> authorities;

}
