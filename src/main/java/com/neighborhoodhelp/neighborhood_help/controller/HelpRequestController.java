package com.neighborhoodhelp.neighborhood_help.controller;

import com.neighborhoodhelp.neighborhood_help.model.HelpRequest;
import com.neighborhoodhelp.neighborhood_help.model.RequestStatus;
import com.neighborhoodhelp.neighborhood_help.service.HelpRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class HelpRequestController {

    private final HelpRequestService helpRequestService;

    // Get all requests assigned to a specific volunteer
    @GetMapping("/volunteer/{volunteerId}")
    public List<HelpRequest> getRequestsByVolunteer(@PathVariable Long volunteerId) {
        return helpRequestService.getRequestsByVolunteer(volunteerId);
    }

    // Get all requests posted by a specific resident
    @GetMapping("/resident/{residentId}")
    public List<HelpRequest> getRequestsByResident(@PathVariable Long residentId) {
        return helpRequestService.getRequestsByResident(residentId);
    }

    // Get all requests filtered by status (OPEN, IN_PROGRESS, COMPLETED)
    @GetMapping("/status/{status}")
    public List<HelpRequest> getRequestsByStatus(@PathVariable RequestStatus status) {
        return helpRequestService.getRequestsByStatus(status);
    }

    // Volunteer claims a request
    @PutMapping("/claim/{requestId}/volunteer/{volunteerId}")
    public HelpRequest claimRequest(@PathVariable Long requestId, @PathVariable Long volunteerId) {
        return helpRequestService.claimRequest(requestId, volunteerId);
    }

    // Mark a request as completed
    @PutMapping("/complete/{requestId}")
    public HelpRequest completeRequest(@PathVariable Long requestId) {
        return helpRequestService.completeRequest(requestId);
    }

    // Optional: Create a new request (by resident)
    @PostMapping("/create")
    public HelpRequest createRequest(@RequestBody HelpRequest helpRequest) {
        return helpRequestService.createRequest(helpRequest);
    }

    // Optional: Get all requests (admin endpoint)
    @GetMapping("/all")
    public List<HelpRequest> getAllRequests() {
        return helpRequestService.getAllRequests();
    }
}

