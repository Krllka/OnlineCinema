package backend.controllers.Impl;


import backend.controllers.AbstractControllerIntrface;
import backend.model.Library;
import backend.model.ProductsData;
import backend.services.Impl.LibraryServiceImpl;
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

    @GetMapping("/get/{name}")
    public List<ProductsData> readByLogin(@PathVariable("name") String login) {
        return  Service.getByLogin(login);
    }

}
