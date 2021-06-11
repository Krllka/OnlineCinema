package backend.DAO.Impl;

import backend.DAO.Intrfaces.OrderDAO;
import backend.model.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.sql.Date;
import java.util.ArrayList;
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
        List<Order> list = session.createQuery("From Order ").list();
        String currID;
        for (Order item: list) {
            currID = item.getId();
            item.setProds(new ArrayList<ProductsData>());


            Query<ProductsInOrder> query  = session.createQuery("from ProductsInOrder o where o.order.id = :currID");
            query.setParameter("currID", currID);
            List<ProductsInOrder> arr = query.list();
            for (ProductsInOrder prod: arr) {
                item.addProds(prod.getProductObj());
            }

        }
        return list;
    }
    @Override
    public Order getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Order item = session.get(Order.class ,id);
        String currID;

        currID = item.getId();
        item.setProds(new ArrayList<ProductsData>());

        Query<ProductsInOrder> query  = session.createQuery("from ProductsInOrder o where o.prod.id = :currID");
        query.setParameter("currID", currID);
        List<ProductsInOrder> arr = query.list();
        for (ProductsInOrder prod: arr) {
            item.addProds(prod.getProductObj());
        }


        return item;
    }
    public List<Order> getByLogin(String client){
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery("FROM Order o where o.client.name = :client");
        query.setParameter("client", client);
        List<Order> list = query.list();
        String currID;
        for (Order item: list) {
            currID = item.getId();
            item.setProds(new ArrayList<ProductsData>());


            Query<ProductsInOrder> query1  = session.createQuery("from ProductsInOrder o where o.order.id = :currID");
            query.setParameter("currID", currID);
            List<ProductsInOrder> arr = query1.list();
            for (ProductsInOrder prod: arr) {
                item.addProds(prod.getProductObj());
            }

        }
        return list;
    }

    public void add(String id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = new Order();
        order.setDate(new Date(System.currentTimeMillis()));
        order.setClient(id);
        order.setStatus(String.valueOf(2));
        ProductsInOrder purchase = new ProductsInOrder();
        double total = 0;
        Query<Library> query  = session.createQuery("from Library o where o.client.id = :id");
        query.setParameter("id", id);
        List<Library> list = query.list();
        session.save(order);
        for (Library item: list) {
            purchase = new ProductsInOrder();
            purchase.setOrder(order.getId());
            total += item.getProductObj().getPrice();
            purchase.setPrice(item.getProductObj().getPrice());
            purchase.setProduct(item.getProductObj());
            item.setPurchased(true);
            session.save(purchase);
        }
        order.setPrice(total);
        session.save(order);
    }
    @Override
    public void edit(Order film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
        String id = film.getClientObj().getId();
        Query<Library> query  = session.createQuery("from Library o where o.client.id = :id");
        query.setParameter("id", id);
        List<Library> list = query.list();
        for (Library item:list) {
            item.setPurchased(true);
            session.save(item);
        }

    }
    @Override
    public void delete(Order film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
        String id = film.getClientObj().getId();
        Query<Library> query  = session.createQuery("from Library o where o.client.id = :id");
        query.setParameter("id", id);
        List<Library> list = query.list();
        for (Library item:list) {
            if(id == item.getClientObj().getId() && !item.getPurchased())
                session.delete(item);
        }
    }


}
