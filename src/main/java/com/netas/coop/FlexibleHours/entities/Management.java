
package com.netas.InventorySystem.entities;

import jakarta.persistence.*;
import lombok.Data;

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