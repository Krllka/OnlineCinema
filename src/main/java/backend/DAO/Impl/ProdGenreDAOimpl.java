package backend.DAO.Impl;

import backend.model.ProductsGenresData;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdGenreDAOimpl extends AbstractDAO<ProductsGenresData>{
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<ProductsGenresData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        List<ProductsGenresData> list = session.createQuery("from ProductsGenresData").list();
        return list;
    }
    @Override
    public ProductsGenresData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProductsGenresData.class ,id);
    }
    @Override
    public void add(ProductsGenresData film) {
        Session session = sessionFactory.getCurrentSession();
        String currID = film.getProd().getId();
        Query<ProductsGenresData> query  = session.createQuery("from ProductsGenresData o where o.prod.id = :currID");
        query.setParameter("currID", currID);
        List<ProductsGenresData> list = query.list();
        for (ProductsGenresData item: list) {
            if(item.equals(film)) {
                System.out.println("-----------------");
                System.out.println(item.equals(film));
                System.out.println("-----------------");
                return;
            }
        }
        session.save(film);
    }
}
