package backend.DAO.Impl;

import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.AbstractEntity;
import backend.model.AccountData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class AbstractDAO<E extends AbstractEntity>  implements AbstractRepo<E> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory.getObject();
    }

    @Override
    public List<E> allAccs() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from "+this.getClass()).list();
    }

    @Override
    public void add(E film) {
        Session session = sessionFactory.getCurrentSession();
        session.save(film);
    }

    @Override
    public void delete(E film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }

    @Override
    public void edit(E film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }
    @Override
    public E getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }
}
