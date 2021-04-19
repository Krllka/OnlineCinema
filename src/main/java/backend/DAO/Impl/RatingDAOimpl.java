package backend.DAO.Impl;

import backend.DAO.Intrfaces.RatingDAO;
import backend.model.RatingData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingDAOimpl extends AbstractDAO<RatingData>
        implements RatingDAO {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<RatingData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();

        return session.createSQLQuery("SELECT * From rating").list();
    }
    @Override
    public RatingData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(RatingData.class ,id);
    }
}
