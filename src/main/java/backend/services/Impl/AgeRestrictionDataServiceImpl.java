package backend.services.Impl;

import backend.DAO.Impl.AgeRestrictionDAOimpl;
import backend.model.AgeRestrictionData;
import backend.services.Intrfaces.AgeRestrictionDataService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("RatingService")
@Transactional
public class AgeRestrictionDataServiceImpl extends AbsctractService<AgeRestrictionData, AgeRestrictionDAOimpl>
        implements AgeRestrictionDataService {
    AgeRestrictionDataServiceImpl(AgeRestrictionDAOimpl dao ){
        super(dao);
    }
}
