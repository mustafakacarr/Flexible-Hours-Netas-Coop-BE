package com.netas.coop.FlexibleHours.responses;

import com.netas.coop.FlexibleHours.entities.OffDayEntity;
import lombok.Data;

@Data

public class OffDayResponse {
    private long id;
    private long startDate;
    private long endDate;
    private String description;
    private long userId;

    public OffDayResponse(OffDayEntity offDayEntity) {
        this.id = offDayEntity.getId();
        this.startDate = offDayEntity.getStartDate();
        this.endDate = offDayEntity.getEndDate();

        this.description = offDayEntity.getDescription();
        this.userId = offDayEntity.getUserEntity().getId();
    }
}
