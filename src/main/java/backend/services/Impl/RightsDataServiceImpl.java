package backend.services.Impl;

import backend.DAO.Impl.RightsDAOimpl;
import backend.model.RightsData;
import backend.services.Intrfaces.RightsDataService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("RightsDataService")
@Transactional
public class RightsDataServiceImpl extends AbsctractService<RightsData, RightsDAOimpl>
        implements RightsDataService {

    RightsDataServiceImpl(RightsDAOimpl dao ){
        super(dao);
    }
}
