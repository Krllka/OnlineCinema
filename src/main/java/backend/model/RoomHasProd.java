package backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "rooms_has_accouts")
public class RoomHasProd extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "Rooms_ID", foreignKey = @ForeignKey(name = "fk_Rooms_has_Products_Products1_idx") )
    private RoomData room;
    @ManyToOne
    @JoinColumn(name = "Accouts_ID", foreignKey = @ForeignKey(name = "fk_Rooms_has_Products_Rooms1_idx") )
    private AccountData acc;

    public RoomHasProd(){}
    public RoomHasProd(String s){super(s);}

    public RoomData getRoom() {
        return room;
    }

    public void setRoom(RoomData room) {
        this.room = room;
    }
    public void setRoom(String room) {
        this.room = new RoomData(room);
    }

    public AccountData getAcc() {
        return acc;
    }

    public void setAcc(AccountData acc) {
        this.acc = acc;
    }
}
