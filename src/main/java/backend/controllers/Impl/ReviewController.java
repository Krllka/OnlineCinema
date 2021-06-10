package backend.controllers.Impl;

import backend.model.Review;
import backend.services.Impl.ReviewService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("review")
public class ReviewController extends AbstractController<Review, ReviewService>{
    public  ReviewController(ReviewService Service) {
        super(Service);
    }
}
