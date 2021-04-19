package backend.services.Impl;

import backend.DAO.Impl.ProductsDAOimpl;
import backend.model.ProductsData;
import backend.services.Intrfaces.ProductsDataService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service("ProductsService")
@Transactional
public class ProductsDataServiceImpl extends AbsctractService<ProductsData, ProductsDAOimpl>
        implements ProductsDataService {

    ProductsDataServiceImpl(ProductsDAOimpl dao ){
                super(dao);
    }
}
