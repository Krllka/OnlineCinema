package backend.services.Impl;

import backend.DAO.Impl.ActorsDAO;
import backend.DAO.Impl.AgeRestrictionDAOimpl;
import backend.model.Actors;
import backend.services.Intrfaces.AbstractServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class ActorsService extends AbsctractService<Actors, ActorsDAO>
            implements AbstractServiceInterface<Actors> {
    ActorsService(ActorsDAO dao ){
        super(dao);
    }
}
