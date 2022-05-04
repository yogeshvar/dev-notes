package org.tektutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {

	public static void main(String[] args) {
		 HttpURLConnection connection = null;
		    BufferedReader reader = null;
		    String retVal = null;
		    try {
		        URL resetEndpoint = new URL("https://cat-fact.herokuapp.com/facts/591f98783b90f7150a19c198");
		        connection = (HttpURLConnection) resetEndpoint.openConnection();
		        // Set request method to GET as required from the API
		        connection.setRequestMethod("GET");

		        // Read the response
		        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		        StringBuilder jsonSb = new StringBuilder();
		        String line = null;
		        while ((line = reader.readLine()) != null) {
		          jsonSb.append(line);
		        }
		        retVal = jsonSb.toString();

		        // print out the json response
		        System.out.println(retVal);

		      } catch (Exception e) {
		        e.printStackTrace();
		      } 
	}

}
