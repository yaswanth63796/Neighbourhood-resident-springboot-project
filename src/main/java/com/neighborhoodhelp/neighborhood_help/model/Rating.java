package com.neighborhoodhelp.neighborhood_help.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The volunteer being rated
    @ManyToOne
    @JoinColumn(name = "volunteer_id", nullable = false)
    private User volunteer;

    // The resident who gives the rating
    @ManyToOne
    @JoinColumn(name = "resident_id", nullable = false)
    private User resident;

    // Score 1-5
    private int score;

    // Optional review text
    private String review;

    // Optional link to HelpRequest (so you can know which request was rated)
    @OneToOne
    @JoinColumn(name = "help_request_id", unique = true)
    private HelpRequest helpRequest;
}
