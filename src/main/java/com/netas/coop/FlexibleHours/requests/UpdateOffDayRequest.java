package com.netas.coop.FlexibleHours.requests;

public record UpdateOffDayRequest(
    long id,
    long startDate,
    long endDate,
    String description,
    long userId
) {
    
}
