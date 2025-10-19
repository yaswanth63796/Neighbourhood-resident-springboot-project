package com.neighborhoodhelp.neighborhood_help.service;




import com.neighborhoodhelp.neighborhood_help.model.*;
import com.neighborhoodhelp.neighborhood_help.repository.*;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class HelpRequestService {
    private final HelpRequestRepository helpRequestRepository;
    private final UserRepository userRepository;

    public HelpRequestService(HelpRequestRepository helpRequestRepository, UserRepository userRepository) {
        this.helpRequestRepository = helpRequestRepository;
        this.userRepository = userRepository;
    }

    public HelpRequest createRequest(Long postedById, HelpRequest req) {
        User user = userRepository.findById(postedById).orElseThrow();
        req.setPostedBy(user);
        req.setStatus(RequestStatus.OPEN);
        req.setCreatedAt(Instant.now());
        return helpRequestRepository.save(req);
    }

    public List<HelpRequest> getAllRequests() {
        return helpRequestRepository.findAll();
    }
}
