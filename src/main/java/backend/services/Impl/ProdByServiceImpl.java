package backend.services.Impl;

import backend.DAO.Impl.ProdByDAOimpl;
import backend.model.ProdByData;
import backend.services.Intrfaces.AbstractServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Transactional
@Service
public class ProdByServiceImpl extends AbsctractService<ProdByData, ProdByDAOimpl>
        implements AbstractServiceInterface<ProdByData> {
    ProdByServiceImpl(ProdByDAOimpl dao ){
        super(dao);
    }
}
