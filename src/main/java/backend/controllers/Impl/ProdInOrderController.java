package backend.controllers.Impl;

import backend.model.ProductsInOrder;
import backend.services.Impl.ProdInOrderServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("orders_prod")
public class ProdInOrderController extends AbstractController<ProductsInOrder, ProdInOrderServiceImpl>{
    public  ProdInOrderController(ProdInOrderServiceImpl Service) {
        super(Service);
    }
}
