package backend.DAO.Impl;

import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.Actors;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActorsDAO extends AbstractDAO<Actors>
            implements AbstractRepo<Actors> {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<Actors> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();

        return session.createQuery(" From Actors").list();
    }
    @Override
    public Actors getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Actors.class ,id);
    }
}
