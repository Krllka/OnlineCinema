package backend.controllers;

import backend.model.AccountData;
import backend.services.AccountDataService;
import backend.services.AccountDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("accounts")
public class AccController {

    private AccountDataService accService;
    @Autowired
    public void setAccService(AccountDataServiceImpl accService) {
        this.accService = accService;
    }
    @GetMapping
    public List<AccountData> allAccs() {
        return accService.allAccs();
    }


    @GetMapping("/error")
    public String editPage() {

        return "error";
    }
}