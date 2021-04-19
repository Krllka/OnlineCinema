package backend.DAO.Impl;

import backend.DAO.Intrfaces.BankCardDAO;
import backend.model.BankCardData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BankCardDAOimpl extends AbstractDAO<BankCardData>
        implements BankCardDAO {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<BankCardData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();

        return session.createQuery("from BankCardData").list();
    }
    @Override
    public BankCardData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(BankCardData.class ,id);
    }
}
