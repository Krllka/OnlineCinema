package backend.controllers.Impl;

import backend.model.Order;
import backend.model.ProductsData;
import backend.response.Response;
import backend.services.Impl.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("orders")
public class OrderController extends  AbstractController<Order, OrderServiceImpl>{

    public  OrderController(OrderServiceImpl Service) {
        super(Service);
    }


    @GetMapping("/get/{name}")
    public List<Order> get(@PathVariable("name") String login) {
        return super.Service.getByLogin(login);
    }

    @PostMapping("/{id}")
    public String generateOrder(@PathVariable("id") String inputAcc) {

            Service.add(inputAcc);
            return "Успешно";

    }

}
