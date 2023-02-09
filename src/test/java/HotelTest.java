import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel holidayinn;
    Bedroom honeymoonsuite;
    Bedroom fundungeon;
    ConferenceRoom masonica;
    ConferenceRoom thermopylae;
    Guest ourFirstGuest;
    Guest ourSecondGuest;
    DiningRoom banquethall;
    DiningRoom slopbucket;
    @Before
    public void setup() {
        honeymoonsuite = new Bedroom(RoomType.DOUBLE, 457, 90);
        fundungeon = new Bedroom(RoomType.SINGLE, 458, 100);

        masonica = new ConferenceRoom(1500, "masonica");
        thermopylae = new ConferenceRoom(300, "thermopylae");

        banquethall = new DiningRoom(20, "Banquet Hall");
        slopbucket = new DiningRoom(25, "Slop Bucket");

        ArrayList<Bedroom> bedrooms = new ArrayList<>();
        ArrayList<ConferenceRoom> conferenceRooms = new ArrayList<>();
        ArrayList<DiningRoom> diningRooms = new ArrayList<>();

        bedrooms.add(honeymoonsuite); bedrooms.add(fundungeon);
        conferenceRooms.add(masonica); conferenceRooms.add(thermopylae);
        diningRooms.add(banquethall); diningRooms.add(slopbucket);

        holidayinn = new Hotel(bedrooms, conferenceRooms, diningRooms);

        ourFirstGuest = new Guest("Steve");
        ourSecondGuest = new Guest("Ben");
    }

    @Test
    public void canCheckInGuest () {
        ArrayList<Bedroom> availableBedrooms = holidayinn.getAvailableBedrooms();
        Bedroom room = availableBedrooms.get(0);
        holidayinn.checkInGuest(room, ourFirstGuest);
        holidayinn.checkInGuest(room, ourSecondGuest);
        assertEquals(2, honeymoonsuite.getOccupants().size());
    }


    @Test
    public void canCheckOutGuest () {
        ArrayList<Bedroom> availableBedrooms = holidayinn.getAvailableBedrooms();
        Bedroom room = availableBedrooms.get(0);
        holidayinn.checkInGuest(room, ourFirstGuest);
        holidayinn.checkInGuest(room, ourSecondGuest);
        holidayinn.checkOutGuest(room, ourSecondGuest);
        assertEquals(1, honeymoonsuite.getOccupants().size());
    }

    @Test
    public void canBookRoom(){
        Booking booking = holidayinn.bookRoom(honeymoonsuite, 7);
        assertEquals(7, booking.getDuration());
        assertEquals(honeymoonsuite, booking.getBedroom());
    }
    @Test
    public void canGetDiningRoomsHashMap () {
        HashMap<String, DiningRoom> hashmap = holidayinn.getDiningRoomsHashmap();
        assertEquals(banquethall, hashmap.get("Banquet Hall"));
    }

}
