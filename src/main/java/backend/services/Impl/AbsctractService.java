package backend.services.Impl;

import backend.DAO.Impl.AbstractDAO;
import backend.DAO.Intrfaces.AbstractRepo;
import backend.model.AbstractEntity;
import backend.services.Intrfaces.AbstractServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;
import java.util.List;

@MappedSuperclass
@Service
@Transactional
public abstract class AbsctractService<E extends AbstractEntity, R extends AbstractDAO<E>>
        implements AbstractServiceInterface<E> {


    private R repo;

    @Autowired
    public AbsctractService(R repo) {
        this.repo = repo;
    }

    @Transactional
    public List<E> allAccs() {
        return repo.allAccs();
    }


    @Transactional
    public void add(E  ent) {
        repo.add(ent);
    }


    @Transactional
    public void delete(E  ent) {
        repo.delete(ent);
    }


    @Transactional
    public void edit(E ent) {
        repo.edit(ent);
    }

    @Transactional
    public E getById(String id){
        return repo.getById(id);
    }

}
