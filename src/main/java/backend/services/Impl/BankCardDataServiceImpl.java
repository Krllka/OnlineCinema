package backend.services.Impl;

import backend.DAO.Impl.BankCardDAOimpl;
import backend.model.BankCardData;
import backend.services.Intrfaces.BankCardDataService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("BankCardDataService")
@Transactional
public class BankCardDataServiceImpl extends AbsctractService<BankCardData, BankCardDAOimpl>
        implements BankCardDataService {

    BankCardDataServiceImpl(BankCardDAOimpl dao ){
        super(dao);
    }
}
