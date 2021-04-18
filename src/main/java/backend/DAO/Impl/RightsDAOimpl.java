package backend.DAO.Impl;

import backend.DAO.Intrfaces.RightsDAO;
import backend.model.RightsData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RightsDAOimpl extends AbstractDAO<RightsData>
        implements RightsDAO {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<RightsData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();

        return session.createQuery("from RightsData").list();
    }
    @Override
    public RightsData getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(RightsData.class ,id);
    }
}
