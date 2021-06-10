package backend.controllers.Impl;

import backend.controllers.AbstractControllerIntrface;
import backend.model.AbstractEntity;
import backend.services.Intrfaces.AbstractServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<E extends AbstractEntity, S extends AbstractServiceInterface<E>>
        implements AbstractControllerIntrface<E> {

    protected S Service;
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
    public E create(@RequestBody E inputAcc ) {
        try{
           Service.add(inputAcc);
           return inputAcc;

        }catch (Exception ex){

           return null;
        }
    }
    @PutMapping("/{id}")
    public E edit(@PathVariable("id") String id,   E editAcc) {
        E save = null;
        try{
             save = Service.getById(id);
            BeanUtils.copyProperties(editAcc, save, "id");
            Service.edit(save);
        }catch (IllegalArgumentException ex){

        }

        return save;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        try{
            Service.delete(Service.getById(id));
        }catch(IllegalArgumentException ex){

        }
    }

}

