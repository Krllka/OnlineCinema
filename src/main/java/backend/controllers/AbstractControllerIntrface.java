package backend.controllers;

import backend.model.AbstractEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AbstractControllerIntrface<E extends AbstractEntity>{
    @GetMapping
    public List<E> allAccs();
    @GetMapping("/{id}")
    public E read(@PathVariable("id") int id);
    @PostMapping
    public E create(@RequestBody E inputAcc);
    @PutMapping("/{id}")
    public E edit( @PathVariable("id") int id, @RequestBody E editAcc);
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id);
}
