package backend.controllers.Impl;


import backend.controllers.AbstractControllerIntrface;
import backend.model.Library;
import backend.services.Impl.LibraryServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("library")
public class LibraryController extends AbstractController<Library, LibraryServiceImpl>
        implements AbstractControllerIntrface<Library> {
    public  LibraryController(LibraryServiceImpl Service) {
        super(Service);
    }
}
