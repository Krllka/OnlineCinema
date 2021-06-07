package backend.controllers.Impl;

import backend.model.Prod_Awards;
import backend.services.Prod_AwardsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("prodAwards")
public class Prod_AwardsController extends AbstractController<Prod_Awards, Prod_AwardsService>{
    public  Prod_AwardsController(Prod_AwardsService Service) {
        super(Service);
    }
}
