package backend.services.Impl;


import backend.DAO.Impl.LibraryDAOimpl;
import backend.model.Library;
import backend.services.Intrfaces.LibraryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("LibService")
@Transactional
public class LibraryServiceImpl extends AbsctractService<Library, LibraryDAOimpl>
        implements LibraryService {
    LibraryServiceImpl(LibraryDAOimpl dao ){
        super(dao);
    }
}
