package ru.stqa.mfp.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("87.117.56.21");
        assertTrue(ipLocation.contains("RU"));
    }
    @Test(enabled = false)
    public void testInvalidMyIp() {
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("87.117.56.xx");
        assertTrue(ipLocation.contains("RU"));
    }
}
