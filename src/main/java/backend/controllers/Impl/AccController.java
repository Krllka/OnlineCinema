package backend.controllers.Impl;

import backend.model.AccountData;
import backend.model.SexData;
import backend.response.Response;
import backend.services.Impl.AccountDataServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("accounts")
public class AccController extends  AbstractController<AccountData, AccountDataServiceImpl>{

    public  AccController(AccountDataServiceImpl Service) {
        super(Service);
    }



    @GetMapping("/{login}/{pass}")
    public Response read(@PathVariable("login") String login ,@PathVariable("pass") String pass) {
       try {
           return Service.tryAuth(login, pass);

       }catch (Exception ex){
           return new Response();
       }

    }





}

