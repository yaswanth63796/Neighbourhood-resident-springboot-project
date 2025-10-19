package com.neighborhoodhelp.neighborhood_help.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

// Correct import for your enum
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

    @ManyToOne
    @JoinColumn(name = "posted_by", nullable = false)
    private User postedBy;

    private String title;
    private String description;
    private String category;

    @Enumerated(EnumType.STRING)  // Works correctly with your enum
    private RequestStatus status;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private User volunteer;

    private Instant createdAt;
    private Instant completedAt;
}
