package backend.DAO.Impl;

import backend.DAO.Intrfaces.AccDAO;
import backend.model.AccountData;
import backend.model.Order;
import backend.response.Response;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public void add(AccountData film) {
        Session session = sessionFactory.getCurrentSession();
        film.setAdmin(false);
        session.save(film);
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

    public Response tryAuth(String client, String pass){
        Session session = sessionFactory.getCurrentSession();
        Query<AccountData> query = session.createQuery("FROM AccountData o where o.name = :client");
        query.setParameter("client", client);
        AccountData ord = query.getSingleResult();
        Response resp =  new Response();
        if(ord != null){
            resp.setExist(true);
            if(ord.chekPass(pass))
            {
                resp.setAccess(true);
                resp.setAdmin(ord.getAdmin());
                resp.setId(ord.getId());
            }
        }

        return resp;
    }

}

