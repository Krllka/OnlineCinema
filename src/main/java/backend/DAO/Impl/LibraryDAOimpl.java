package backend.DAO.Impl;

import backend.DAO.Intrfaces.LibraryDAO;
import backend.model.Library;
import backend.model.ProductsData;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class LibraryDAOimpl extends AbstractDAO<Library>
    implements LibraryDAO{
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<Library> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        return session.createQuery("from Library").list();
    }
    @Override
    public Library getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Library.class ,id);
    }

    public List<ProductsData> getByLogin(String client){
        Session session = sessionFactory.getCurrentSession();
        Query<Library> query = session.createQuery("FROM Library o where o.client.name = :client");
        query.setParameter("client", client);
        List<Library> ord = query.list();
        List<ProductsData> prods = new ArrayList<>();
        for (Library item: ord) {
            prods.add(item.getProuctObj());
        }
        return prods;
    }
}
