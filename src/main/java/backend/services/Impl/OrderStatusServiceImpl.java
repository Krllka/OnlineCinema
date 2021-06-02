package backend.services.Impl;

import backend.DAO.Impl.OrderStatusDAOimpl;
import backend.model.OrderStatus;
import backend.services.Intrfaces.AbstractServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class OrderStatusServiceImpl extends AbsctractService<OrderStatus, OrderStatusDAOimpl>
    implements AbstractServiceInterface<OrderStatus> {
    OrderStatusServiceImpl(OrderStatusDAOimpl dao ){
        super(dao);
    }
}
