package backend.DAO.Impl;

import backend.DAO.Intrfaces.SexDAO;
import backend.model.SexData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SexDAOImpl implements SexDAO {
    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory.getObject();
    }

    @Override
    public List<SexData> allAccs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from  SexData").list();
    }

    @Override
    public void add(SexData film) {
        Session session = sessionFactory.getCurrentSession();
        session.save(film);
    }

    @Override
    public void delete(SexData film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }

    @Override
    public void edit(SexData film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }

    @Override
    public SexData getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(SexData.class, id);
    }
}
