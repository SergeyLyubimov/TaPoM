package com.example.demo.service;

import com.example.demo.domain.Review;
import com.example.demo.repo.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void scrape(String website) {
        // Я сейчас не считаю важным делать логику скрейпа вебсайта
        Review test = new Review();
        reviewRepository.save(test);
    }
}
