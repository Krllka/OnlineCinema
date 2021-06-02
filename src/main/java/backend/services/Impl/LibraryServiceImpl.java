package backend.services.Impl;


import backend.DAO.Impl.LibraryDAOimpl;
import backend.model.Library;
import backend.model.ProductsData;
import backend.services.Intrfaces.LibraryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("LibService")
@Transactional
public class LibraryServiceImpl extends AbsctractService<Library, LibraryDAOimpl>
        implements LibraryService {
    LibraryServiceImpl(LibraryDAOimpl dao ){
        super(dao);
    }
    public List<ProductsData> getByLogin(String client){return repo.getByLogin(client);}
}
