package com.neighborhoodhelp.neighborhood_help.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

// Enums
import com.neighborhoodhelp.neighborhood_help.model.RequestStatus;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "help_requests")
public class HelpRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    // The resident who posted the request
    @ManyToOne
    @JoinColumn(name = "posted_by", nullable = false)
    private User postedBy;

    private String title;
    private String description;
    private String category;

    // Status of the request
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    // The volunteer assigned to this request
    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private User volunteer;

    // Timestamps
    private Instant createdAt;
    private Instant completedAt;

    // Optional: Rating ID or object if you implement rating later
    // @OneToOne(mappedBy = "helpRequest")
    // private Rating rating;
}
