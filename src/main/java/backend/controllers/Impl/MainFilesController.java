package backend.controllers.Impl;

import backend.controllers.AbstractControllerIntrface;
import backend.model.MainFileData;
import backend.model.ProductsData;
import backend.services.Impl.MainFilesDataServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("mainFiles")
public class MainFilesController extends AbstractController<MainFileData, MainFilesDataServiceImpl>{
    public MainFilesController(MainFilesDataServiceImpl service) {
        super(service);
    }
    @Value("${upload.path}")
    String upDir;


    @RequestMapping(value = "/files/{file_name:.+}", method = RequestMethod.GET)
    public void getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) throws IOException {

        Path file = Paths.get(upDir, fileName);

        if (Files.exists(file)){

            response.setContentType("image/jpeg");

            try {
                Files.copy(file,  response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException e) {

            }
        }
    }
    @PostMapping("/add")
    public String upLoadFile(@RequestParam("file") MultipartFile file) throws IOException {


        if(file != null){

            File uploadDir = new File(AbstractControllerIntrface.class.getResource("").getPath()+"/Uploads");
            if(!uploadDir.exists())
                System.out.println(uploadDir.mkdir());;


            String resultFilename =  file.getOriginalFilename();
            file.transferTo(new File(upDir +"/" + resultFilename));

        }

        return "";


    }
}
