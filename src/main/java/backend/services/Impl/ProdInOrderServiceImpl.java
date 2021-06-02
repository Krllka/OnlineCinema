package backend.services.Impl;

import backend.DAO.Impl.ProdInOrderDAOimpl;
import backend.model.ProductsInOrder;
import backend.services.Intrfaces.AbstractServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProdInOrderServiceImpl extends AbsctractService<ProductsInOrder, ProdInOrderDAOimpl>
    implements AbstractServiceInterface<ProductsInOrder> {
    ProdInOrderServiceImpl(ProdInOrderDAOimpl dao ){
        super(dao);
    }
}
