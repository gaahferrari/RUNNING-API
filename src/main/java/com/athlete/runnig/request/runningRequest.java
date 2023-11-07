package com.athlete.runnig.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class runningRequest {

    private Long athleteId;

    private Long eventId;

    private String pace;

    private String ranking;

}
