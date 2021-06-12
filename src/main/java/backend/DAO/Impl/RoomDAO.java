package backend.DAO.Impl;

import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomDAO extends AbstractDAO<RoomData>
        implements AbstractRepo<RoomData> {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<RoomData> allAccs() {

        Session session = super.sessionFactory.getCurrentSession();
        List<RoomData> list = session.createQuery("From RoomData ").list();
        return list;
    }
    @Override
    public RoomData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(RoomData.class ,id);
    }


}
