package backend.services.Impl;

import backend.DAO.Impl.GenreDAOimpl;
import backend.model.GenreData;
import backend.services.Intrfaces.GenreServcie;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("GenreSrevice")
@Transactional
public class GenreServiceImpl extends  AbsctractService<GenreData, GenreDAOimpl> implements GenreServcie {
    GenreServiceImpl(GenreDAOimpl dao ){
        super(dao);
    }
}
