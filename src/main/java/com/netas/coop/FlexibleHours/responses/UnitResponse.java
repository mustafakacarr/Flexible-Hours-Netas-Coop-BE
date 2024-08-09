package com.netas.coop.FlexibleHours.responses;

import com.netas.coop.FlexibleHours.entities.UnitEntity;

import lombok.Data;

@Data
public class UnitResponse {
    private long id;
    private String name;

    public UnitResponse(UnitEntity unitEntity) {
        this.id = unitEntity.getId();
        this.name = unitEntity.getName();
    }
}
