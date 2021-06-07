package backend.controllers.Impl;


import backend.model.ProdByData;
import backend.services.Impl.ProdByServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("prodBy")
public class ProdByController extends AbstractController<ProdByData, ProdByServiceImpl> {
    public  ProdByController(ProdByServiceImpl Service) {
        super(Service);
    }
}
