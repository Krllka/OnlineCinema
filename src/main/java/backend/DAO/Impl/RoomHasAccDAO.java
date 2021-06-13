package backend.DAO.Impl;

import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.RoomHasAccs;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RoomHasAccDAO extends AbstractDAO<RoomHasAccs>
    implements AbstractRepo<RoomHasAccs> {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<RoomHasAccs> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        List<RoomHasAccs> list = session.createQuery("from RoomHasAccs").list();
        return list;
    }
    @Override
    public RoomHasAccs getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(RoomHasAccs.class ,id);
    }
}
