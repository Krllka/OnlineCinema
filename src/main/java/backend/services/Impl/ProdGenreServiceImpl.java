package backend.services.Impl;

import backend.DAO.Impl.ProdGenreDAOimpl;
import backend.model.ProductsGenresData;
import backend.services.Intrfaces.ProdGenresService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("Prod-genre")
@Transactional
public class ProdGenreServiceImpl extends AbsctractService<ProductsGenresData, ProdGenreDAOimpl>
        implements ProdGenresService {

    ProdGenreServiceImpl(ProdGenreDAOimpl dao ){
        super(dao);
    }
}
