package ro.mxp.booking.core.service;

import ro.mxp.booking.core.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);
    Rating getRatingById(int id);
    List<Rating> getAllRating();
    Rating updateRating(Rating rating);
    void deleteRating(int id);

}
