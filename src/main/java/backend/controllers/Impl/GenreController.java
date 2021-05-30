package backend.controllers.Impl;

import backend.controllers.AbstractControllerIntrface;
import backend.model.GenreData;
import backend.services.Impl.GenreServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("genre")
public class GenreController extends AbstractController<GenreData, GenreServiceImpl>
        implements AbstractControllerIntrface<GenreData> {
    public  GenreController(GenreServiceImpl Service) {
        super(Service);
    }
}
