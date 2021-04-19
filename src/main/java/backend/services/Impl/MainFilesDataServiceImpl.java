package backend.services.Impl;

import backend.DAO.Impl.MainFilesDAOimpl;
import backend.model.MainFileData;
import backend.services.Intrfaces.MainFilesDataService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("MainFileService")
@Transactional
public class MainFilesDataServiceImpl extends AbsctractService<MainFileData, MainFilesDAOimpl>
        implements MainFilesDataService {
    MainFilesDataServiceImpl(MainFilesDAOimpl dao ){
        super(dao);
    }
}
