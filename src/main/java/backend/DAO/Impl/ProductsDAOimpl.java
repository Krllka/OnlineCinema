package backend.DAO.Impl;

import backend.DAO.Intrfaces.ProductDAO;
import backend.model.*;
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
            item.setActors(new ArrayList<ProdByData>());
            item.setAwards(new ArrayList<Awards>());
            //--------------------------Жанры--------------------------
                Query<ProductsGenresData> query  = session.createQuery("from ProductsGenresData o where o.prod.id = :currID");
                query.setParameter("currID", currID);
                List<ProductsGenresData> arr = query.list();
                for (ProductsGenresData genres: arr) {
                    item.addGenre(genres.getGenre());
                }
            //--------------------------Жанры--------------------------
            //--------------------------Награды------------------------

                Query<Prod_Awards> query2  = session.createQuery("from Prod_Awards o where o.prod.id = :currID");
                query2.setParameter("currID", currID);
                List<Prod_Awards> arr2 = query2.list();
                for (Prod_Awards prod: arr2) {
                    item.addAward(prod.getAward());
                }
            //--------------------------Награды------------------------
            //--------------------------Актёры-------------------------

                Query<ProdByData> query3 = session.createQuery("from ProdByData o where o.prod.id = :currID");
                query3.setParameter("currID", currID);
                List<ProdByData> arr3 = query3.list();
                for (ProdByData prod: arr3) {
                    item.addActor(prod);
                }
            //--------------------------Актёры-------------------------
        }
        return list;
    }
    @Override
    public void delete(ProductsData item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void add(ProductsData film) {
        Session session = sessionFactory.getCurrentSession();
        session.save(film);
        for (GenreData item: film.getGenres()) {

           ProdGenreDAOimpl.tryAdd(session, new ProductsGenresData(item, film));

        }
        for (Awards item: film.getAwards()) {

            session.save(new Prod_Awards(item, film));

        }
        for (ProdByData item: film.getActors()) {
            item.setProd(film.getId());
            session.save(item);
        }

    }

    @Override
    public ProductsData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        ProductsData prod = session.get(ProductsData.class ,id);
        prod.setGenres(new ArrayList<GenreData>());

        String currID = prod.getId();
        prod.setGenres(new ArrayList<GenreData>());
        prod.setActors(new ArrayList<ProdByData>());
        prod.setAwards(new ArrayList<Awards>());
        //--------------------------Жанры--------------------------
        Query<ProductsGenresData> query  = session.createQuery("from ProductsGenresData o where o.prod.id = :currID");
        query.setParameter("currID", currID);
        List<ProductsGenresData> arr = query.list();
        for (ProductsGenresData genres: arr) {
            prod.addGenre(genres.getGenre());
        }
        //--------------------------Жанры--------------------------
        //--------------------------Награды------------------------
        Query<Prod_Awards> query2  = session.createQuery("from Prod_Awards o where o.prod.id = :currID");
        query2.setParameter("currID", currID);
        List<Prod_Awards> arr2 = query2.list();
        for (Prod_Awards aw: arr2) {
            prod.addAward(aw.getAward());
        }
        //--------------------------Награды------------------------
        //--------------------------Актёры-------------------------
        Query<ProdByData> query3 = session.createQuery("from ProdByData o where o.prod.id = :currID");
        query3.setParameter("currID", currID);
        List<ProdByData> arr3 = query3.list();
        for (ProdByData actr: arr3) {
            prod.addActor(actr);
        }
        //--------------------------Актёры-------------------------

        return prod;
    }


}
