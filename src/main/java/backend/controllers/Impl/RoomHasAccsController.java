package backend.controllers.Impl;

import backend.model.RoomHasAccs;
import backend.services.Impl.RoomHasAccService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping("roomAccs")
public class RoomHasAccsController extends AbstractController<RoomHasAccs, RoomHasAccService>{
    public  RoomHasAccsController(RoomHasAccService Service) {
        super(Service);
    }
}
