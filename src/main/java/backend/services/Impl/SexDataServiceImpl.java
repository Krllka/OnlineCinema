package backend.services.Impl;

import backend.DAO.Intrfaces.AccDAO;
import backend.DAO.Intrfaces.SexDAO;
import backend.model.SexData;
import backend.model.SexData;
import backend.services.Intrfaces.SexDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service("SexDataService")
@Transactional
public class SexDataServiceImpl implements SexDataService {
    private SexDAO sexDAO;
    @Autowired
    public void setAccDAO(SexDAO sexDAO) {
        this.sexDAO = sexDAO;
    }

    @Override
    @Transactional
    public List<SexData> allAccs() {
        return sexDAO.allAccs();
    }

    @Override
    @Transactional
    public void add(SexData film) {
        sexDAO.add(film);
    }

    @Override
    @Transactional
    public void delete(SexData film) {
        sexDAO.delete(film);
    }

    @Override
    @Transactional
    public void edit(SexData film) {
        sexDAO.edit(film);
    }

    @Override
    @Transactional
    public SexData getById(int id) {
        return sexDAO.getById(id);
    }
}
