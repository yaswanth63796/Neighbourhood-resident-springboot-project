package com.neighborhoodhelp.neighborhood_help.repository;

import com.neighborhoodhelp.neighborhood_help.model.HelpRequest;
import com.neighborhoodhelp.neighborhood_help.model.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {

    List<HelpRequest> findByVolunteer_UserId(Long volunteerId);

    List<HelpRequest> findByPostedBy_UserId(Long residentId);

    List<HelpRequest> findByStatus(RequestStatus status);

    // ADD THIS METHOD:
    long countByStatus(RequestStatus status);
}
