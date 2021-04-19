package backend.controllers.Impl;

import backend.controllers.AbstractControllerIntrface;
import backend.model.AbstractEntity;
import backend.model.AccountData;
import backend.services.Intrfaces.AbstractServiceInterface;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<E extends AbstractEntity, S extends AbstractServiceInterface<E>>
        implements AbstractControllerIntrface<E> {

    private S Service;
    @Autowired
    public AbstractController(S Service) {
        this.Service = Service;
    }
    @GetMapping
    public List<E> allAccs() {
        return Service.allAccs();
    }
    @GetMapping("/{id}")
    public E read(@PathVariable("id") String id) {
        return Service.getById(id);
    }
    @PostMapping
    public E create(@RequestBody E inputAcc) {
       try{
           Service.add(inputAcc);
           return inputAcc;

       }catch (Exception ex){

            inputAcc.setId("-1");
            return inputAcc;
       }

    }
    @PutMapping("/{id}")
    public E edit(@PathVariable("id") String id,   E editAcc) {
        E save = Service.getById(id);
        BeanUtils.copyProperties(editAcc, save, "id");
        Service.edit(save);
        return save;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        Service.delete(Service.getById(id));
    }

}

