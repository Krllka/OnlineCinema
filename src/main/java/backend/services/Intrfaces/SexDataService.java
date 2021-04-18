package backend.services.Intrfaces;

import backend.model.SexData;

import java.util.List;

public interface SexDataService extends AbstractServiceInterface<SexData>{
    List<SexData> allAccs();
    void add(SexData film);
    void delete(SexData film);
    void edit(SexData film);
    SexData getById(int id);
}
