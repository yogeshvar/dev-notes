package tektutor;


import com.lavasoft.GeoIPService;
import com.lavasoft.GeoIPServiceSoap;

public class IPLocationFinder {
	
	public static void main(String[] args) {
			System.setProperty("java.net.useSystemProxies","true");
			GeoIPService geoIpService = new GeoIPService();
			GeoIPServiceSoap geoIpServiceSoap = geoIpService.getGeoIPServiceSoap();
			String result = geoIpServiceSoap.getIpLocation("106.51.16.172");
			System.out.println(result);
	}
}
