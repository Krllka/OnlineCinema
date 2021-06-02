package backend.DAO.Impl;

import backend.DAO.Intrfaces.OrderDAO;
import backend.model.Order;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OrderDAOimpl extends AbstractDAO<Order>
    implements OrderDAO {

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<Order> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        List<Order> list = session.createQuery("from Order").list();
        return list;
    }
    @Override
    public Order getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class ,id);
    }
    public Order getByLogin(String client){
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery("FROM Order o where o.client.name = :client");
        query.setParameter("client", client);
        Order ord = query.getSingleResult();
        return ord;
    }



}
