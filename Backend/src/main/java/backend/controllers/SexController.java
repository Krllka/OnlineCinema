package backend.controllers;

import backend.model.SexData;
import backend.services.Intrfaces.SexDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("sex")
public class SexController {
    private SexDataService sexService;

    @Autowired
    public void setAccService(SexDataService sexService) {
        this.sexService = sexService;
    }
    @GetMapping
    public List<SexData> allAccs() {
        return sexService.allAccs();
    }
    @GetMapping("/{id}")
    public SexData read(@PathVariable("id") int id) {
        return sexService.getById(id);
    }
    @PostMapping
    public SexData create(@RequestBody SexData inputAcc) {
        sexService.add(inputAcc);
        return inputAcc;
    }
    @PutMapping("/{id}")
    public SexData edit(@PathVariable("id") int id , @RequestBody SexData editSex) {
        SexData save = sexService.getById(id);
        editSex.setId(save.getId());
        sexService.edit(editSex);
        return save;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        sexService.delete(sexService.getById(id));
    }


}
