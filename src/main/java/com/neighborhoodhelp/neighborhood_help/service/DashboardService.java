package com.neighborhoodhelp.neighborhood_help.service;



import com.neighborhoodhelp.neighborhood_help.model.RequestStatus;
import com.neighborhoodhelp.neighborhood_help.repository.HelpRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final HelpRequestRepository helpRequestRepository;

    public Map<String, Long> getDashboardStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalRequests", helpRequestRepository.count());
        stats.put("openRequests", helpRequestRepository.countByStatus(RequestStatus.OPEN));
        stats.put("inProgressRequests", helpRequestRepository.countByStatus(RequestStatus.IN_PROGRESS));
        stats.put("completedRequests", helpRequestRepository.countByStatus(RequestStatus.COMPLETED));
        return stats;
    }
}