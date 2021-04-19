package backend.controllers.Impl;

import backend.model.RatingData;
import backend.services.Impl.ProductsDataServiceImpl;
import backend.services.Impl.RatingDataServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("rating")
public class RatingController extends AbstractController<RatingData , RatingDataServiceImpl> {
    public RatingController(RatingDataServiceImpl Service) {
        super(Service);
    }
}
