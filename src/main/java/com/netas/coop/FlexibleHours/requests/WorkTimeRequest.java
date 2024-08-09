package com.netas.coop.FlexibleHours.requests;

import java.time.LocalTime;

public record WorkTimeRequest(LocalTime startTime, LocalTime endTime) {

}
