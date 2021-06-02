package backend.services.Intrfaces;

import backend.model.Order;

public interface OrderService extends AbstractServiceInterface<Order>{
    Order getByLogin(String login);
}
