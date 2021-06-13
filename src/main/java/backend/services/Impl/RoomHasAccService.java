package backend.services.Impl;

import backend.DAO.Impl.ReviewDAO;
import backend.DAO.Impl.RoomHasAccDAO;
import backend.model.RoomHasAccs;
import backend.services.Intrfaces.AbstractServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoomHasAccService extends AbsctractService<RoomHasAccs, RoomHasAccDAO>
    implements AbstractServiceInterface<RoomHasAccs> {
    RoomHasAccService(RoomHasAccDAO dao ){
        super(dao);
    }
}
