package com.athlete.runnig.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Running {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String pace;

    private String ranking;

}
