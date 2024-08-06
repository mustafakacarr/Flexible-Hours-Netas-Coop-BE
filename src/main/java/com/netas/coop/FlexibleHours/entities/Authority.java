
package com.netas.InventorySystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorityId;

    private String authorityRole;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}