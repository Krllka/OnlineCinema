package backend.DAO.Impl;

import backend.DAO.Intrfaces.LibraryDAO;
import backend.model.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibraryDAOimpl extends AbstractDAO<Library>
    implements LibraryDAO{
    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<Library> allAccs() {
        Session session = super.sessionFactory.getCurrentSession();
        return session.createQuery("from Library").list();
    }
    @Override
    public Library getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Library.class ,id);
    }

    @Override
    public void add(Library film) {
        Session session = sessionFactory.getCurrentSession();
        film.setPurchased(false);

        String currID = film.getProductObj().getId();
        Query<Library> query  = session.createQuery("from Library o where o.product.id = :currID");
        query.setParameter("currID", currID);
        List<Library> list = query.list();
        for (Library item: list) {
            if(item.equals(film)) {
                System.out.println("-----------------");
                System.out.println(item.equals(film));
                System.out.println("-----------------");
                return;
            }
        }
        session.save(film);
    }

    public void deleteByLogin(String login, String prod){
        Session session = sessionFactory.getCurrentSession();
        Query<Library> query = session.createQuery("FROM Library o where o.client.name = :client");
        query.setParameter("client", login);

        List<Library> ord = query.list();

        for (Library item: ord) {
            if(item.getProduct().equals(prod))
                session.delete(item);
        }

    }

    public List<ProductsData> getByLogin(String client, String type){
        Session session = sessionFactory.getCurrentSession();
        Query<Library> query = session.createQuery("FROM Library o where o.client.name = :client");
        query.setParameter("client", client);
        boolean basket = type.equals("basket");
        List<Library> ord = query.list();
        List<ProductsData> prods = new ArrayList<>();
        for (Library item: ord) {
            if(item.getPurchased() & !basket)
                prods.add(getProdById(item.getProductObj().getId()));
            if(!item.getPurchased() & basket)
                prods.add(getProdById(item.getProductObj().getId()));
        }
        return prods;
    }

    //----------------------
    public ProductsData getProdById(String id) {
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

        return prod;
    }

}
