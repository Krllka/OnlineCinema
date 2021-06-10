package backend.DAO.Impl;

import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.ProfessionsData;
import backend.model.Review;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDAO extends AbstractDAO<Review>
        implements AbstractRepo<Review> {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<Review> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        return session.createQuery("from Review ").list();
    }
    @Override
    public Review getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Review.class ,id);
    }
}
