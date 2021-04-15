package backend.services.Intrfaces;

import backend.model.SexData;

import java.util.List;

public interface SexDataService {
    List<SexData> allAccs();
    void add(SexData film);
    void delete(SexData film);
    void edit(SexData film);
    SexData getById(int id);
}
