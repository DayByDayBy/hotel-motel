import java.util.ArrayList;

public abstract class Room {

    private ArrayList<Guest> occupants;
    private int capacity;

    public Room(int capacity) {
        this.occupants = new ArrayList<>();
        this.capacity = capacity;
    }
    public int getCapacity(){
        return this.capacity;
    }

    public ArrayList<Guest> getOccupants() {
        return occupants;
    }

    public void addGuest(Guest guest) {
        if (occupants.size() < capacity) {
            occupants.add(guest);
        }
    }

    public void removeGuest(Guest guest) {
        occupants.remove(guest);
    }

    public static double getSize(double length, double width) {
        return length * width;
    }
}
