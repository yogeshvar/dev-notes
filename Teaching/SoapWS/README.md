## Introduction to SOAP API: 

---


Step 1: 
Create a new Java Project in Eclipse.

---

Step 2: 
Open your terminal in the same active directory and type `wsimport`

(Note: if not available, set the `JAVA_HOME` correctly and try again)

```
 wsimport -keep src http://wsgeoip.lavasoft.com/ipservice.asmx?WSDL
```

---

Step 3:  Copy the downloaded files into your repo using the same package name.

---

Step 4: 

Code to use the `getIPLocation` function


```
GeoIPService geoIpService = new GeoIPService();
GeoIPServiceSoap geoIpServiceSoap = geoIpService.getGeoIPServiceSoap();
String result = geoIpServiceSoap.getIpLocation("106.51.16.172");
System.out.println(result);
```

