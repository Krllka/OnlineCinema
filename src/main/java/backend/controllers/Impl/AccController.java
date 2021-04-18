package backend.controllers.Impl;

import backend.model.AccountData;
import backend.services.Impl.AccountDataServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("accounts")
public class AccController extends  AbstractController<AccountData, AccountDataServiceImpl>{

    public  AccController(AccountDataServiceImpl accService) {
        super(accService);
    }

}

