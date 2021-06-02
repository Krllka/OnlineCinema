package backend.services.Impl;

import backend.DAO.Impl.OrderDAOimpl;
import backend.model.Order;
import backend.services.Intrfaces.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("OrderService")
@Transactional
public class OrderServiceImpl extends AbsctractService<Order, OrderDAOimpl>
    implements OrderService {

    OrderServiceImpl(OrderDAOimpl dao ){
        super(dao);
    }
    @Transactional
    public Order getByLogin(String login){
        return super.repo.getByLogin(login);
    }

}
