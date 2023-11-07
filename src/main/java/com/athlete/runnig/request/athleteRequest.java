package com.athlete.runnig.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class athleteRequest {
    private String name;
    private String category;
    private String age;
    private String cpf;
}
