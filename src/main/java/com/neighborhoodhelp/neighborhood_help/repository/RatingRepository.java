package com.neighborhoodhelp.neighborhood_help.repository;



import com.neighborhoodhelp.neighborhood_help.model.Rating;
import com.neighborhoodhelp.neighborhood_help.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByVolunteer(User volunteer);   // Get all ratings for a volunteer
    List<Rating> findByResident(User resident);     // Get all ratings by a resident
}

