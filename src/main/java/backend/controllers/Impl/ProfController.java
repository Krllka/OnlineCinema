package backend.controllers.Impl;


import backend.model.ProfessionsData;
import backend.services.Impl.ProfServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("prof")
public class ProfController extends AbstractController<ProfessionsData, ProfServiceImpl>{
    public  ProfController(ProfServiceImpl Service) {
        super(Service);
    }
}
