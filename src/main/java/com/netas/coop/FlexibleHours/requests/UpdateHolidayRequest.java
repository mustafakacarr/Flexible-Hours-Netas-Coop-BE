package com.netas.coop.FlexibleHours.requests;

public record UpdateHolidayRequest(
    long id,
    long startDate,
    long endDate,
    String name
) {
    
}
