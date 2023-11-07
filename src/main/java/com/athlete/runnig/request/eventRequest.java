package com.athlete.runnig.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class eventRequest {

    private Long id;

    private String name;

    private Date eventDate;

    private String eventTime;

    private String address;

    protected Double price;

    private Double studentPrice;
}
