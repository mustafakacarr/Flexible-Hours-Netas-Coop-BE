
package com.netas.InventorySystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "work_calendars")
public class WorkCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recordId;

    private String date;

    @ManyToOne
    @JoinColumn(name = "work_time_id")
    private WorkTime workTime;

    @ManyToOne
    @JoinColumn(name = "special_date_id")
    private SpecialDate specialDate;
}