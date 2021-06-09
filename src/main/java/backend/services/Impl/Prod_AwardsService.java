package backend.services.Impl;

import backend.DAO.Impl.Prod_AwardsDAO;
import backend.model.Prod_Awards;
import backend.services.Impl.AbsctractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Prod_AwardsService extends AbsctractService<Prod_Awards, Prod_AwardsDAO> {
    Prod_AwardsService(Prod_AwardsDAO dao ){
        super(dao);
    }
}
