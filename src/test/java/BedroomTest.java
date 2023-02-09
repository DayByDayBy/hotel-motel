import org.junit.Before;

public class BedroomTest {
    Bedroom bedroom;
    @Before
    public void setup() {
        bedroom = new Bedroom(RoomType.DOUBLE, 457, 90);
    }
}
