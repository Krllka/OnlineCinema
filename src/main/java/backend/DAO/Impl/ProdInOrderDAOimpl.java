package backend.DAO.Impl;

import backend.model.ProductsInOrder;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdInOrderDAOimpl extends AbstractDAO<ProductsInOrder>{
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<ProductsInOrder> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        List<ProductsInOrder> list = session.createQuery("from ProductsInOrder").list();
        return list;
    }
    @Override
    public ProductsInOrder getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProductsInOrder.class ,id);
    }
}
