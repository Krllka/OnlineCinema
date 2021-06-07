package backend.DAO.Impl;

import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.MainFileData;
import backend.model.ProfessionsData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfDAOimpl extends AbstractDAO<ProfessionsData>
                        implements AbstractRepo<ProfessionsData> {
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<ProfessionsData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        return session.createQuery("from ProfessionsData ").list();
    }
    @Override
    public ProfessionsData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProfessionsData.class ,id);
    }
}
