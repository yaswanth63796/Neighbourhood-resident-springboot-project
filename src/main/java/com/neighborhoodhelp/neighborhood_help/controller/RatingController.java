package com.neighborhoodhelp.neighborhood_help.controller;



import com.neighborhoodhelp.neighborhood_help.model.Rating;
import com.neighborhoodhelp.neighborhood_help.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    // Submit a rating for a completed request
    @PostMapping("/submit")
    public Rating submitRating(@RequestParam Long helpRequestId,
                               @RequestParam Long residentId,
                               @RequestParam int score,
                               @RequestParam(required = false) String review) {
        return ratingService.submitRating(helpRequestId, residentId, score, review);
    }

    // Get all ratings for a volunteer
    @GetMapping("/volunteer/{volunteerId}")
    public List<Rating> getRatingsByVolunteer(@PathVariable Long volunteerId) {
        return ratingService.getRatingsByVolunteer(volunteerId);
    }

    // Get all ratings submitted by a resident
    @GetMapping("/resident/{residentId}")
    public List<Rating> getRatingsByResident(@PathVariable Long residentId) {
        return ratingService.getRatingsByResident(residentId);
    }
}
