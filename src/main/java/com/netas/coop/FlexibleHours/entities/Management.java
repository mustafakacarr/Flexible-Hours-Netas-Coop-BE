package com.netas.coop.FlexibleHours.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name = "managements")
public class Management {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long managementId;

    private String managementName;

    @OneToMany(mappedBy = "management")
    private List<Department> departments;
}