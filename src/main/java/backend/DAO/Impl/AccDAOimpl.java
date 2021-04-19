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

        return session.createSQLQuery("Select accounts.ID, accounts.Login, accounts.mail, accounts.password, sex.Name\n" +
                "from (accounts  left join sex on accounts.Sex_ID = sex.ID) ").list();
    }
    @Override
    public AccountData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(AccountData.class ,id);
    }
}

