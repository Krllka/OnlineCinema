package backend.services.Impl;

import backend.DAO.Impl.AccDAOimpl;
import backend.DAO.Impl.SexDAOImpl;
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
public class SexDataServiceImpl extends AbsctractService<SexData, SexDAOImpl>
        implements SexDataService {
    SexDataServiceImpl(SexDAOImpl dao ){
        super(dao);
    }



}
