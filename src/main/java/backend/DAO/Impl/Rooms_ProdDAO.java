package backend.DAO.Impl;

import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.RoomData;
import backend.model.Rooms_Products;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Rooms_ProdDAO extends AbstractDAO<Rooms_Products>
            implements AbstractRepo<Rooms_Products> {

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<Rooms_Products> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        List<Rooms_Products> list = session.createQuery("from Rooms_Products").list();
        return list;
    }
    @Override
    public Rooms_Products getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Rooms_Products.class ,id);
    }

}
