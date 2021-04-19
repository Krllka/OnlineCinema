package backend.DAO.Impl;

import backend.DAO.Intrfaces.SexDAO;
import backend.model.SexData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SexDAOImpl extends AbstractDAO<SexData>
implements SexDAO {

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<SexData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();

        return session.createQuery("from SexData").list();
    }
    @Override
    public SexData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(SexData.class ,id);
    }
}
