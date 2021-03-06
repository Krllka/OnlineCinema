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
            item.setActors(new ArrayList<Actors>());
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
                    item.addActor(prod.getProfObj());
                }
            //--------------------------Актёры-------------------------
            Query<MainFileData> query4 = session.createQuery("from MainFileData o where o.prod_id = :currID");
            query4.setParameter("currID", currID);
            try{
                MainFileData arr4 = query4.getSingleResult();
                item.setMainFile(arr4.getFilePath());
            }catch (Exception ex){}

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
        if( film.getGenres() != null )
            for (GenreData item : film.getGenres()) {

                ProdGenreDAOimpl.tryAdd(session, new ProductsGenresData(item, film));

            }
        if( film.getAwards() != null )
            for (Awards item : film.getAwards()) {

                session.save(new Prod_Awards(item, film));

            }
        if( film.getActors() != null )
            for (Actors item : film.getActors()) {
                session.save(new ProdByData(item, film));
            }
        session.save(new MainFileData(film.getMainFile(), film.getId()));
    }

    @Override
    public ProductsData getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        ProductsData prod = session.get(ProductsData.class ,id);
        if(prod == null) return null;
        prod.setGenres(new ArrayList<GenreData>());



        String currID = prod.getId();
        prod.setGenres(new ArrayList<GenreData>());
        prod.setActors(new ArrayList<Actors>());
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
            prod.addActor(actr.getProfObj());
        }
        //--------------------------Актёры-------------------------
        //--------------------------Файл_Фильма-------------------------
        Query<MainFileData> query4 = session.createQuery("from MainFileData o where o.prod_id = :currID");
        query4.setParameter("currID", currID);
        try{
            MainFileData arr4 = query4.getSingleResult();
            prod.setMainFile(arr4.getFilePath());
        }catch (Exception ex){}
        //--------------------------Файл_Фильма-------------------------

        return prod;
    }

    @Override
    public void edit(ProductsData film) {
        Session session = sessionFactory.getCurrentSession();
        Query qu = session.createSQLQuery("DELETE  FROM products_has_genre WHERE Products_ID = :id" );
        qu.setParameter("id", Integer.valueOf(film.getId()));
        qu.executeUpdate();
        qu =  session.createSQLQuery("DELETE  FROM products_has_awards  WHERE Products_ID = :id" );
        qu.setParameter("id", Integer.valueOf(film.getId()));
        qu.executeUpdate();
        qu = session.createSQLQuery("DELETE  FROM prod_by WHERE Products_ID = :id" );
        qu.setParameter("id", Integer.valueOf(film.getId()));
        qu.executeUpdate();
        qu = session.createSQLQuery("DELETE  FROM mainfiles WHERE Products_ID = :id" );
        qu.setParameter("id", Integer.valueOf(film.getId()));
        qu.executeUpdate();
        if( film.getGenres() != null )
            for (GenreData item : film.getGenres()) {

                ProdGenreDAOimpl.tryAdd(session, new ProductsGenresData(item, film));

            }
        if( film.getAwards() != null )
            for (Awards item : film.getAwards()) {

                session.save(new Prod_Awards(item, film));

            }
        if( film.getActors() != null )
            for (Actors item : film.getActors()) {
                session.save(new ProdByData(item, film));
            }
        if( film.getMainFile() != null ){
            session.save(new MainFileData(film.getMainFile(), film.getId()));
        }

        session.merge(film);
    }
}
