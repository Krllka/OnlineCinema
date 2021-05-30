package backend.controllers.Impl;

import backend.controllers.AbstractControllerIntrface;
import backend.model.ProductsGenresData;
import backend.services.Impl.ProdGenreServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("prod_genres")

public class ProdGenreController extends AbstractController<ProductsGenresData , ProdGenreServiceImpl>
{

    public ProdGenreController(ProdGenreServiceImpl service) {
        super(service);
    }
}
