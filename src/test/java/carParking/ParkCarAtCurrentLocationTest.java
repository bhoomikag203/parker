package carParking;

import baseTest.BaseTest;
import org.testng.annotations.Test;

public class ParkCarAtCurrentLocationTest extends BaseTest {

    @Test
    public void shouldParkCarAtCurrentLocation() {

        homeScreen.park()
                .assertParked();
    }

}