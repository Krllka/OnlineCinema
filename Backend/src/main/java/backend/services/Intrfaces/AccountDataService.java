package backend.services.Intrfaces;

import backend.model.AccountData;

import java.util.List;

public interface AccountDataService {
    List<AccountData> allAccs();
    void add(AccountData film);
    void delete(AccountData film);
    void edit(AccountData film);
    AccountData getById(int id);
}