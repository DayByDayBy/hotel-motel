public class Booking {
    Bedroom bedroom;
    int duration;

    public Booking(Bedroom bedroom, int duration) {
        this.bedroom = bedroom;
        this.duration = duration;
    }

    public Bedroom getBedroom() {
        return bedroom;
    }

    public int getDuration() {
        return duration;
    }

    public int getTotalCost() {
        return bedroom.getNightlyRate()*duration;
    }
}
