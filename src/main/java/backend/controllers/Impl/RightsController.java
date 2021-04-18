package backend.controllers.Impl;

import backend.model.BankCardData;
import backend.model.RightsData;
import backend.services.Impl.BankCardDataServiceImpl;
import backend.services.Impl.RightsDataServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("rights")
public class RightsController  extends AbstractController<RightsData, RightsDataServiceImpl>{
    public RightsController(RightsDataServiceImpl service) {
        super(service);
    }
}
