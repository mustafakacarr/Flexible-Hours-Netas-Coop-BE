package com.netas.coop.FlexibleHours.requests;

import com.netas.coop.FlexibleHours.entities.UnitEntity;

public record DepartmentRequest(String name, UnitEntity unitEntity) {
}
