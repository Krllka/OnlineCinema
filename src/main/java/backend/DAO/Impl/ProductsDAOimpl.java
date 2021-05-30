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
        List<ProductsData> list = session.createQuery("From ProductsData ").list();
        return list;
    }
    @Override
    public void delete(ProductsData film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
        session.createQuery("delete from author_book where author_id=film.getID()").list();

    }

    @Override
    public ProductsData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProductsData.class ,id);
    }
}
