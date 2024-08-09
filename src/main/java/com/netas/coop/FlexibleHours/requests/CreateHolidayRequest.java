package com.netas.coop.FlexibleHours.requests;

public record CreateHolidayRequest(
    long startDate,
    long endDate,
    String name
) {
    
}
