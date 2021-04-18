package backend.controllers.Impl;

import backend.model.BankCardData;
import backend.services.Impl.BankCardDataServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("bankcard")
public class BankCardController extends AbstractController<BankCardData, BankCardDataServiceImpl>{
        public BankCardController(BankCardDataServiceImpl service) {
        super(service);
        }
}
