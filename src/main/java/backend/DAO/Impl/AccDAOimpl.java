package backend.DAO.Impl;

import backend.DAO.Intrfaces.AccDAO;
import backend.model.AccountData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccDAOimpl extends AbstractDAO<AccountData>
    implements AccDAO{

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<AccountData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        List<AccountData> list = session.createQuery("from AccountData").list();
        return list;
    }
    @Override
    public AccountData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(AccountData.class ,id);
    }
}

