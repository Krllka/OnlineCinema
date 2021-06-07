package backend.DAO.Impl;

import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.ProdByData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProdByDAOimpl extends AbstractDAO<ProdByData>
            implements AbstractRepo<ProdByData> {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<ProdByData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        return session.createQuery("from ProdByData ").list();
    }
    @Override
    public ProdByData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProdByData.class ,id);
    }

}
