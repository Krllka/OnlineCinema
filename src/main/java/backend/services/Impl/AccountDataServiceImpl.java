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
    public void add(AccountData film) {
        accDAO.add(film);
    }

    @Override
    @Transactional
    public void delete(AccountData film) {
        accDAO.delete(film);
    }

    @Override
    @Transactional
    public void edit(AccountData film) {
        accDAO.edit(film);
    }

    @Override
    @Transactional
    public AccountData getById(int id) {
        return accDAO.getById(id);
    }
}
