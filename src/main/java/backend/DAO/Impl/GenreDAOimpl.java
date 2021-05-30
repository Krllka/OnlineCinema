package backend.DAO.Impl;


import backend.DAO.Intrfaces.GenreDAO;
import backend.model.GenreData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDAOimpl extends AbstractDAO<GenreData> implements GenreDAO{
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<GenreData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        List<GenreData> list = session.createQuery("from GenreData").list();
        return list;
    }
    @Override
    public GenreData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(GenreData.class ,id);
    }

}
