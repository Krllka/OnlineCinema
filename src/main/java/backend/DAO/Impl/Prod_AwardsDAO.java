package backend.DAO.Impl;

import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.Prod_Awards;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Prod_AwardsDAO extends AbstractDAO<Prod_Awards>
                    implements AbstractRepo<Prod_Awards> {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<Prod_Awards> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        List<Prod_Awards> list = session.createQuery("from Prod_Awards").list();
        return list;
    }
    @Override
    public Prod_Awards getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Prod_Awards.class ,id);
    }
}
