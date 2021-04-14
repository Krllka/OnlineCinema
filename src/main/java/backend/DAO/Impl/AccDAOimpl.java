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
public class AccDAOimpl implements AccDAO {


    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory.getObject();
    }

    @Override
    public List<AccountData> allAccs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from  AccountData").list();
    }

    @Override
    public void add(AccountData film) {
        Session session = sessionFactory.getCurrentSession();
        session.save(film);
    }

    @Override
    public void delete(AccountData film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }

    @Override
    public void edit(AccountData film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }

    @Override
    public AccountData getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(AccountData.class, id);
    }
}
