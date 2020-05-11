import org.testng.annotations.Test;

public class parkCarAtCurrentLocationTest extends BaseTest {

    @Test
    public void shouldParkCarAtCurrentLocation() {

        homeScreen.park()
                .assertParked();
    }

}