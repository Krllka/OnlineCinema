package backend.services.Impl;

import backend.DAO.Impl.AccDAOimpl;
import backend.model.AccountData;
import backend.response.Response;
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
    @Transactional
    public Response tryAuth(String client, String pass){
       return repo.tryAuth(client, pass);
    }
}
