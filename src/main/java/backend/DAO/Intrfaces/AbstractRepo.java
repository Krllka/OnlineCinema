package backend.DAO.Intrfaces;

import backend.model.AbstractEntity;

import java.util.List;


public interface AbstractRepo<E extends AbstractEntity> {
    List<E> allAccs();
    void add(E film);
    void delete(E film);
    void edit(E film);
    E getById(int id);
}
