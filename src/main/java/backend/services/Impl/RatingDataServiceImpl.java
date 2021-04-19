package backend.services.Impl;

import backend.DAO.Impl.RatingDAOimpl;
import backend.model.RatingData;
import backend.services.Intrfaces.RatingDataService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("RatingService")
@Transactional
public class RatingDataServiceImpl extends AbsctractService<RatingData, RatingDAOimpl>
        implements RatingDataService {
    RatingDataServiceImpl(RatingDAOimpl dao ){
        super(dao);
    }
}
