package backend.services.Impl;

import backend.DAO.Impl.AwardsDAO;
import backend.DAO.Impl.ProfDAOimpl;
import backend.model.Awards;
import backend.services.Intrfaces.AbstractServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AwardsService extends AbsctractService<Awards, AwardsDAO>
                            implements AbstractServiceInterface<Awards> {
    AwardsService(AwardsDAO dao ){
        super(dao);
    }
}
