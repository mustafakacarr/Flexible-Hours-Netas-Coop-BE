package com.netas.coop.FlexibleHours.responses;

import com.netas.coop.FlexibleHours.entities.WorkTimeEntity;
import lombok.Data;

import java.time.LocalTime;

@Data
public class WorkTimeResponse {
 private LocalTime startTime;
    private LocalTime endTime;

    public WorkTimeResponse(WorkTimeEntity workTimeEntity) {
       this.startTime = workTimeEntity.getStartTime();
         this.endTime = workTimeEntity.getEndTime();
    }
}
