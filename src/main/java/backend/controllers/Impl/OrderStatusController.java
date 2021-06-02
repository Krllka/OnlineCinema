package backend.controllers.Impl;

import backend.model.OrderStatus;
import backend.services.Impl.OrderServiceImpl;
import backend.services.Impl.OrderStatusServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("order_status")
public class OrderStatusController extends AbstractController<OrderStatus, OrderStatusServiceImpl>{
    public  OrderStatusController(OrderStatusServiceImpl Service) {
        super(Service);
    }
}
