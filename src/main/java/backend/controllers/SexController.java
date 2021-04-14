package backend.controllers;

import backend.model.AccountData;
import backend.services.Intrfaces.AccountDataService;
import backend.services.Impl.AccountDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SexController {
    private AccountDataService accService;
    @Autowired
    public void setAccService(AccountDataServiceImpl accService) {
        this.accService = accService;
    }
    @GetMapping
    public List<AccountData> allAccs() {
        return accService.allAccs();
    }
    @GetMapping("/{id}")
    public AccountData read(@PathVariable("id") int id) {
        return accService.getById(id);
    }
    @PostMapping
    public AccountData create(@RequestBody AccountData inputAcc) {
        accService.add(inputAcc);
        return inputAcc;
    }
    @PutMapping("/{id}")
    public AccountData edit(@PathVariable("id") int id , @RequestBody AccountData editAcc) {
        AccountData save = accService.getById(id);
        editAcc.setId(save.getId());
        accService.edit(editAcc);
        return save;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        accService.delete(accService.getById(id));
    }


}
