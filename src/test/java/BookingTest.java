import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    Booking booking;
    Bedroom bedroom;

    @Before
    public void setup(){
        bedroom = new Bedroom(RoomType.DOUBLE, 665, 90);
        booking = new Booking(bedroom, 7);
    }
    @Test
    public void canGetTotalCost () {
        assertEquals(630, booking.getTotalCost());
    }
}
