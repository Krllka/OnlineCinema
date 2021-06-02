package backend.DAO.Intrfaces;

import backend.model.Order;

public interface OrderDAO extends AbstractRepo<Order>{
    public Order getByLogin(String login);
}
