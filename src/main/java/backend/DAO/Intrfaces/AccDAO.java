package backend.DAO.Intrfaces;

import backend.model.AccountData;

import java.util.List;

public interface AccDAO {
    List<AccountData> allAccs();
    void add(AccountData film);
    void delete(AccountData film);
    void edit(AccountData film);
    AccountData getById(int id);
}
