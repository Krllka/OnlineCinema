package backend.DAO.Impl;

import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.OrderStatus;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderStatusDAOimpl extends AbstractDAO<OrderStatus>
    implements AbstractRepo<OrderStatus> {

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<OrderStatus> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        List<OrderStatus> list = session.createQuery("from OrderStatus ").list();
        return list;
    }
    @Override
    public OrderStatus getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(OrderStatus.class ,id);
    }
}
