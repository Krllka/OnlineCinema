package backend.controllers.Impl;

import backend.model.RoomData;
import backend.services.Impl.RoomService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("room")
public class RoomController extends AbstractController<RoomData, RoomService>{
    public RoomController(RoomService Service) {
        super(Service);
    }
}
