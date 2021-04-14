package backend.services.Impl;

import backend.DAO.Intrfaces.AccDAO;
import backend.model.AccountData;
import backend.services.Intrfaces.AccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service("AccountDataService")
@Transactional
public class AccountDataServiceImpl implements AccountDataService {

    private AccDAO accDAO;
    @Autowired
    public void setAccDAO(AccDAO accDAO) {
        this.accDAO = accDAO;
    }

    @Override
    @Transactional
    public List<AccountData> allAccs() {
        return accDAO.allAccs();
    }

    @Override
    @Transactional
    public void add(AccountData  account) {
        accDAO.add( account);
    }

    @Override
    @Transactional
    public void delete(AccountData  account) {
        accDAO.delete( account);
    }

    @Override
    @Transactional
    public void edit(AccountData  account) {
        accDAO.edit( account);
    }

    @Override
    @Transactional
    public AccountData getById(int id) {
        return accDAO.getById(id);
    }
}
