package ro.mxp.booking.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.mxp.booking.core.entity.Rating;
import ro.mxp.booking.core.service.RatingService;

import java.util.List;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    public Rating createRating(Rating rating) {
        return ratingService.createRating(rating);
    }

    public Rating getRatingById(int id) {
        return ratingService.getRatingById(id);
    }

    public List getAllRating() {
        return ratingService.getAllRating();
    }

    public Rating updateRating(Rating rating) {
        return ratingService.updateRating(rating);
    }

    public void deleteRating(int id) {
        ratingService.deleteRating(id);
    }

}
