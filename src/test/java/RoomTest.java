import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    Bedroom honeymoonsuite;
    ConferenceRoom conferenceRoom;
    Guest ourFirstGuest;
    Guest ourSecondGuest;

    @Before
    public void setup () {
        honeymoonsuite = new Bedroom(RoomType.DOUBLE, 457, 90);
        conferenceRoom = new ConferenceRoom(200, "masonica");
        ourFirstGuest = new Guest("marcella");
        ourSecondGuest = new Guest("eugene");
    }

    @Test
    public void canAddGuestToRoom(){
        honeymoonsuite.addGuest(ourFirstGuest);
        assertEquals(1, honeymoonsuite.getOccupants().size());
    }

    @Test
    public void canRemoveGuestFromRoom(){
        conferenceRoom.addGuest(ourFirstGuest);
        conferenceRoom.addGuest(ourSecondGuest);
        conferenceRoom.removeGuest(ourFirstGuest);
        assertEquals(1, conferenceRoom.getOccupants().size());
    }

    @Test
    public void canGetRoomSize(){
        assertEquals(20000, conferenceRoom.getSize(100, 200), 0.1);
    }

}
