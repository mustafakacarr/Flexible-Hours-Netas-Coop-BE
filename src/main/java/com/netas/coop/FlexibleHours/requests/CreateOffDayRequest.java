package com.netas.coop.FlexibleHours.requests;

public record CreateOffDayRequest(
    long startDate,
    long endDate,
    String description,
    long userId
) {
    
}
