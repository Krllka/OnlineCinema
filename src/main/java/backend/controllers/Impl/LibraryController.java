package backend.controllers.Impl;


import backend.controllers.AbstractControllerIntrface;
import backend.model.Library;
import backend.model.ProductsData;
import backend.services.Impl.LibraryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("library")
public class LibraryController extends AbstractController<Library, LibraryServiceImpl>
        implements AbstractControllerIntrface<Library> {
    public  LibraryController(LibraryServiceImpl Service) {
        super(Service);
    }

    @GetMapping("/{type}/{name}")
    public List<ProductsData> readByLogin(@PathVariable("name") String login, @PathVariable("type") String type) {

        try {
            return  Service.getByLogin(login, type);
        }catch (Exception ex){
            return null;
        }
    }
    @DeleteMapping("/{login}/{prod}")
    public void deleteByLogin(@PathVariable("prod") String prod, @PathVariable("login") String login) {

        try {
            Service.deleteByLogin(login, prod);
        }catch (Exception ex){

        }
        return;
    }

}
