package backend.DAO.Impl;

import backend.DAO.Intrfaces.AgeRestrictionDAO;
import backend.model.AgeRestrictionData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgeRestrictionDAOimpl extends AbstractDAO<AgeRestrictionData>
        implements AgeRestrictionDAO {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<AgeRestrictionData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();

        return session.createSQLQuery("SELECT * From rating").list();
    }
    @Override
    public AgeRestrictionData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(AgeRestrictionData.class ,id);
    }
}
