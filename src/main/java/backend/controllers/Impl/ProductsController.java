package backend.controllers.Impl;

import backend.model.ProductsData;
import backend.services.Impl.ProductsDataServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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


}
