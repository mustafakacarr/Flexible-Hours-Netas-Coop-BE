package com.netas.coop.FlexibleHours.responses;

import com.netas.coop.FlexibleHours.entities.WorkCalendarEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkCalenderResponse {
    private LocalDate date;
    private WorkTimeResponse workTime;
    private long userId;

    public WorkCalenderResponse(WorkCalendarEntity workCalendarEntity) {
        this.date = LocalDate.parse(workCalendarEntity.getDate());
        this.workTime = new WorkTimeResponse(workCalendarEntity.getWorkTimeEntity());
        this.userId = workCalendarEntity.getUserEntity().getId();
}
}
