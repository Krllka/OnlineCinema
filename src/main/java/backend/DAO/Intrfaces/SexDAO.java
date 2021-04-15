package backend.DAO.Intrfaces;

import backend.model.SexData;
import backend.model.SexData;

import java.util.List;

public interface SexDAO {
    List<SexData> allAccs();
    void add(SexData  account);
    void delete(SexData  account);
    void edit(SexData  account);
    SexData getById(int id);
}
