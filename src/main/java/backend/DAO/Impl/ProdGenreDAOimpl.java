package backend.DAO.Impl;

import backend.model.ProductsGenresData;
import org.hibernate.Session;
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
}
