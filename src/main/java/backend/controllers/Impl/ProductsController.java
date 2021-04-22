package backend.controllers.Impl;

import backend.model.ProductsData;
import backend.services.Impl.ProductsDataServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialArray;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;


@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("products")
public class ProductsController extends AbstractController<ProductsData, ProductsDataServiceImpl>{

    public ProductsController(ProductsDataServiceImpl Service) {
        super(Service);
    }
    @Value("${upload.path}")
    String upDir;
    Path downDir =Paths.get("D:/FILES/RENDER/DOWN");

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
    public String create(@RequestParam("file") MultipartFile file) throws IOException {
        ProductsData prodData = new ProductsData();

        if(file != null){
            File uploadDir = new File(upDir);
            if(!uploadDir.exists())
                uploadDir.mkdir();

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            prodData.setPoster(resultFilename);

            file.transferTo(new File(upDir +"/" + resultFilename));

            super.create(prodData);
        }
        return "";
    }

}
