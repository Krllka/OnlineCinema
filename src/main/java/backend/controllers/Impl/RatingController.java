package backend.controllers.Impl;

import backend.model.AgeRestrictionData;
import backend.services.Impl.AgeRestrictionDataServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("rating")
public class RatingController extends AbstractController<AgeRestrictionData, AgeRestrictionDataServiceImpl> {
    public RatingController(AgeRestrictionDataServiceImpl Service) {
        super(Service);
    }
}
