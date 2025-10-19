package com.neighborhoodhelp.neighborhood_help.repository;


import com.neighborhoodhelp.neighborhood_help.model.HelpRequest;
import com.neighborhoodhelp.neighborhood_help.model.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {
    List<HelpRequest> findByStatus(RequestStatus status);
    List<HelpRequest> findByPostedByUserId(Long userId);
    List<HelpRequest> findByVolunteerUserId(Long userId);
}

