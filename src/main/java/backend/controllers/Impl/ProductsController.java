package backend.controllers.Impl;

import backend.model.ProductsData;
import backend.services.Impl.AccountDataServiceImpl;
import backend.services.Impl.ProductsDataServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("products")
public class ProductsController extends AbstractController<ProductsData, ProductsDataServiceImpl>{

    public ProductsController(ProductsDataServiceImpl Service) {
        super(Service);
    }

}
