package com.netas.coop.FlexibleHours.requests;

import java.time.LocalDate;

public record WorkCalenderRequest(LocalDate date, long workTimeId, long userId) {
}
