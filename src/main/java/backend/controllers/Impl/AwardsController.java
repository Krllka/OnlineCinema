package backend.controllers.Impl;


import backend.model.Awards;
import backend.services.Impl.AwardsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("awards")
public class AwardsController extends AbstractController<Awards, AwardsService> {
    public  AwardsController(AwardsService Service) {
        super(Service);
    }
}
