package backend.DAO.Impl;

import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.Awards;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AwardsDAO extends AbstractDAO<Awards>
                        implements AbstractRepo<Awards> {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<Awards> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        return session.createQuery("from Awards").list();
    }
    @Override
    public Awards getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Awards.class ,id);
    }
}
