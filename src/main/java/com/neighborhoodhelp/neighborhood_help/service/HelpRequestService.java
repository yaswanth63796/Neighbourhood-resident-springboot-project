package com.neighborhoodhelp.neighborhood_help.service;

import com.neighborhoodhelp.neighborhood_help.model.HelpRequest;
import com.neighborhoodhelp.neighborhood_help.model.RequestStatus;
import com.neighborhoodhelp.neighborhood_help.model.User;
import com.neighborhoodhelp.neighborhood_help.repository.HelpRequestRepository;
import com.neighborhoodhelp.neighborhood_help.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HelpRequestService {

    private final HelpRequestRepository helpRequestRepository;
    private final UserRepository userRepository;

    // Create a new request
    public HelpRequest createRequest(HelpRequest helpRequest) {
        helpRequest.setStatus(RequestStatus.OPEN);
        helpRequest.setCreatedAt(Instant.now());
        return helpRequestRepository.save(helpRequest);
    }

    // Get all requests (admin / dashboard use)
    public List<HelpRequest> getAllRequests() {
        return helpRequestRepository.findAll();
    }

    // Get requests assigned to a volunteer
    public List<HelpRequest> getRequestsByVolunteer(Long volunteerId) {
        return helpRequestRepository.findByVolunteer_UserId(volunteerId);
    }

    // Get requests posted by a resident
    public List<HelpRequest> getRequestsByResident(Long residentId) {
        return helpRequestRepository.findByPostedBy_UserId(residentId);
    }

    // Get requests by status
    public List<HelpRequest> getRequestsByStatus(RequestStatus status) {
        return helpRequestRepository.findByStatus(status);
    }

    // Volunteer claims a request
    public HelpRequest claimRequest(Long requestId, Long volunteerId) {
        HelpRequest request = helpRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        User volunteer = userRepository.findById(volunteerId)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));

        request.setVolunteer(volunteer);
        request.setStatus(RequestStatus.IN_PROGRESS);

        return helpRequestRepository.save(request);
    }

    // Mark a request as completed
    public HelpRequest completeRequest(Long requestId) {
        HelpRequest request = helpRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus(RequestStatus.COMPLETED);
        request.setCompletedAt(Instant.now());

        return helpRequestRepository.save(request);
    }
}
