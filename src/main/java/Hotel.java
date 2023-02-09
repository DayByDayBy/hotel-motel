import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom> diningRooms;
    private HashMap<String, DiningRoom> diningRoomsHashmap;

    public Hotel(ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms, ArrayList<DiningRoom> diningRooms) {
        this.bedrooms = bedrooms;
        this.conferenceRooms = conferenceRooms;
        this.diningRooms = diningRooms;

        HashMap<String, DiningRoom> drhm = new HashMap<>();
        for (DiningRoom d: diningRooms) {
            String name = d.getName();
            drhm.put(name, d);
        }

        this.diningRoomsHashmap = drhm;
    }

    public ArrayList<Bedroom> getAvailableBedrooms () {
        ArrayList<Bedroom> availableBedrooms = new ArrayList<>();
        for (Bedroom b : bedrooms) {
            if (b.getOccupants().size() == 0) {
                availableBedrooms.add(b);
            }
        }
        return availableBedrooms;
    }

    public void checkInGuest(Room room, Guest guest) {
        room.addGuest(guest);
    }

    public void checkOutGuest(Room room, Guest guest) {
        room.removeGuest(guest);
    }

    public Booking bookRoom(Bedroom bedroom, int duration) {
        Booking booking = new Booking(bedroom, duration);
        return booking;
    }

    public HashMap<String, DiningRoom> getDiningRoomsHashmap() {
        return diningRoomsHashmap;
    }
}
