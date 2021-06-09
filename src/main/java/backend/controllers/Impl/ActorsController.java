package backend.controllers.Impl;

import backend.model.Actors;
import backend.services.Impl.ActorsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("actors")
public class ActorsController extends AbstractController<Actors, ActorsService>{
    public ActorsController(ActorsService Service) {
        super(Service);
    }
}
