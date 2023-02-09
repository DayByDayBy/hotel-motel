public class Bedroom extends Room {
    private int roomNumber;
    private RoomType roomType;
    int nightlyRate;
    public Bedroom(RoomType roomType, int roomNumber, int nightlyRate) {
        super(roomType.getCapacity());
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.nightlyRate = nightlyRate;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }
}
