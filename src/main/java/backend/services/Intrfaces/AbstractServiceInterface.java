package backend.services.Intrfaces;

import backend.model.AbstractEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public interface AbstractServiceInterface<E extends AbstractEntity>{
    List<E> allAccs();
    void add(E film);
    void delete(E film);
    void edit(E film);
    E getById(int id);
}
