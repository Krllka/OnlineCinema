package backend.DAO.Impl;

import backend.DAO.Intrfaces.MainFilesDAO;
import backend.model.MainFileData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MainFilesDAOimpl extends AbstractDAO<MainFileData>
        implements MainFilesDAO {

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<MainFileData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        return session.createSQLQuery("Select * from mainfiles ").list();
    }
    @Override
    public MainFileData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MainFileData.class ,id);
    }
}
