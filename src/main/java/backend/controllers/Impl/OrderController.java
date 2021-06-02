package backend.controllers.Impl;

import backend.model.Order;
import backend.services.Impl.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("orders")
public class OrderController extends  AbstractController<Order, OrderServiceImpl>{

    public  OrderController(OrderServiceImpl Service) {
        super(Service);
    }

    @Override
    @GetMapping("/{name}")
    public Order read(@PathVariable("name") String login) {
        return super.Service.getById(login);
    }

}
