package com.neighborhoodhelp.neighborhood_help.service;



import com.neighborhoodhelp.neighborhood_help.model.HelpRequest;
import com.neighborhoodhelp.neighborhood_help.model.Rating;
import com.neighborhoodhelp.neighborhood_help.model.User;
import com.neighborhoodhelp.neighborhood_help.repository.HelpRequestRepository;
import com.neighborhoodhelp.neighborhood_help.repository.RatingRepository;
import com.neighborhoodhelp.neighborhood_help.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final HelpRequestRepository helpRequestRepository;

    // Submit a rating after request completion
    public Rating submitRating(Long helpRequestId, Long residentId, int score, String review) {
        HelpRequest request = helpRequestRepository.findById(helpRequestId)
                .orElseThrow(() -> new RuntimeException("Help request not found"));

        if (request.getStatus() != com.neighborhoodhelp.neighborhood_help.model.RequestStatus.COMPLETED) {
            throw new RuntimeException("Cannot rate a request that is not completed");
        }

        User resident = userRepository.findById(residentId)
                .orElseThrow(() -> new RuntimeException("Resident not found"));

        User volunteer = request.getVolunteer();
        if (volunteer == null) {
            throw new RuntimeException("No volunteer assigned to this request");
        }

        Rating rating = Rating.builder()
                .helpRequest(request)
                .resident(resident)
                .volunteer(volunteer)
                .score(score)
                .review(review)
                .build();

        return ratingRepository.save(rating);
    }

    // Get all ratings for a volunteer
    public List<Rating> getRatingsByVolunteer(Long volunteerId) {
        User volunteer = userRepository.findById(volunteerId)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
        return ratingRepository.findByVolunteer(volunteer);
    }

    // Get all ratings submitted by a resident
    public List<Rating> getRatingsByResident(Long residentId) {
        User resident = userRepository.findById(residentId)
                .orElseThrow(() -> new RuntimeException("Resident not found"));
        return ratingRepository.findByResident(resident);
    }
}
