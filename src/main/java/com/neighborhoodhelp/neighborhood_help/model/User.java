package com.neighborhoodhelp.neighborhood_help.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.List;

// Correct import for your enum
import com.neighborhoodhelp.neighborhood_help.model.Role;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)  // This now works correctly
    private Role role;

    private Instant joinDate;

    @OneToMany(mappedBy = "postedBy")
    private List<HelpRequest> postedRequests;

    @OneToMany(mappedBy = "volunteer")
    private List<HelpRequest> assignedRequests;
}

