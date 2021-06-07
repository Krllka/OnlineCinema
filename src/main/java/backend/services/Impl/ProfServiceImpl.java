package backend.services.Impl;

import backend.DAO.Impl.ProfDAOimpl;
import backend.model.ProfessionsData;
import backend.services.Intrfaces.AbstractServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProfServiceImpl extends AbsctractService<ProfessionsData, ProfDAOimpl>
            implements AbstractServiceInterface<ProfessionsData> {
    ProfServiceImpl(ProfDAOimpl dao ){
        super(dao);
    }
}
