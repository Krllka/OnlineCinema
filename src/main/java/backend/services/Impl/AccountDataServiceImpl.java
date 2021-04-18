package backend.services.Impl;

import backend.DAO.Impl.AccDAOimpl;
import backend.model.AccountData;
import backend.services.Intrfaces.AccountDataService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service("AccountDataService")
@Transactional
public class AccountDataServiceImpl extends AbsctractService<AccountData, AccDAOimpl>
        implements AccountDataService {

    AccountDataServiceImpl(AccDAOimpl dao ){
        super(dao);
    }
}
