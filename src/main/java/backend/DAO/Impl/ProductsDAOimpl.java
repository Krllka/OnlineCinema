package backend.DAO.Impl;

import backend.DAO.Intrfaces.ProductDAO;
import backend.model.GenreData;
import backend.model.Library;
import backend.model.ProductsData;
import backend.model.ProductsGenresData;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductsDAOimpl extends AbstractDAO<ProductsData>
        implements ProductDAO {

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<ProductsData> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        List<ProductsData> list = session.createQuery("From ProductsData ").list();
        String currID;
        for (ProductsData item: list) {
            currID = item.getId();
            item.setGenres(new ArrayList<GenreData>());
            Query<ProductsGenresData> query  = session.createQuery("from ProductsGenresData o where o.prod.id = :currID");
            query.setParameter("currID", currID);
            List<ProductsGenresData> arr = query.list();
            for (ProductsGenresData genres: arr) {
                item.addGenre(genres.getGenre());
            }
        }
        return list;
    }
    @Override
    public void delete(ProductsData film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
      //  session.createSQLQuery("$DELETE FROM author_book WHERE author_id={film.getId()}").list();

    }



    @Override
    public ProductsData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        ProductsData prod = session.get(ProductsData.class ,id);
        prod.setGenres(new ArrayList<GenreData>());
        Query<ProductsGenresData> query  = session.createQuery("from ProductsGenresData o where o.prod.id = :id");
        query.setParameter("id", id);
        List<ProductsGenresData> list = query.list();
        for (ProductsGenresData item: list) {
            prod.addGenre(item.getGenre());
        }
        return prod;
    }
}
