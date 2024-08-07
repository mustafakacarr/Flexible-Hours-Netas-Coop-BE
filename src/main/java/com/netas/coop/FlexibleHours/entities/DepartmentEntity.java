package com.netas.coop.FlexibleHours.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "departments")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private UnitEntity unitEntity;


}
