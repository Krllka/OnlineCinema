package backend.controllers.Impl;

import backend.model.SexData;
import backend.services.Impl.SexDataServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("sex")
public class SexController  extends  AbstractController<SexData, SexDataServiceImpl>{

    public SexController(SexDataServiceImpl service) {
        super(service);
    }

}
