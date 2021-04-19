package backend.DAO.Impl;

import backend.DAO.Intrfaces.ProductDAO;
import backend.model.ProductsData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductsDAOimpl extends AbstractDAO<ProductsData>
        implements ProductDAO {

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<ProductsData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();

        return session.createSQLQuery("SELECT * From products").list();
    }
    @Override
    public ProductsData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProductsData.class ,id);
    }
}
