

package com.netas.InventorySystem.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long permissionId;

    private String date;

    private String explanation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}