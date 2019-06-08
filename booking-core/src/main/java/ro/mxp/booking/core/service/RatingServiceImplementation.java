package ro.mxp.booking.core.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.entity.Rating;
import ro.mxp.booking.core.repository.RatingRepository;

import java.util.List;

@Service("ratingServiceImplementation")
public class RatingServiceImplementation implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRatingById(int id) {
        return ratingRepository.findOne(id);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating updateRating(@NotNull Rating rating) {
        Rating ratingFromDb = ratingRepository.findOne(rating.getId());
        return ratingRepository.save(ratingFromDb);
    }

    @Override
    public void deleteRating(int id) {
        ratingRepository.delete(id);
    }

}
