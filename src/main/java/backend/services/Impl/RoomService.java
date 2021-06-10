package backend.services.Impl;


import backend.DAO.Impl.RoomDAO;
import backend.model.RoomData;
import backend.services.Intrfaces.AbstractServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoomService extends AbsctractService<RoomData, RoomDAO>
        implements AbstractServiceInterface<RoomData> {
    RoomService(RoomDAO dao ){super(dao);}
}
