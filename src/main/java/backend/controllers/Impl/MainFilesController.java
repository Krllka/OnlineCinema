package backend.controllers.Impl;

import backend.model.MainFileData;
import backend.services.Impl.MainFilesDataServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("mainFiles")
public class MainFilesController extends AbstractController<MainFileData, MainFilesDataServiceImpl>{
    public MainFilesController(MainFilesDataServiceImpl service) {
        super(service);
    }
}
