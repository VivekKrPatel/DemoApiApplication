package com.geekster.DemoApiApp;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class DemoApiAppApplication {

	public static void main(String[] args) throws Exception{

		URL getUrl = new URL("https://api.chucknorris.io/jokes/random");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();

		if(responseCode == 200){

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer jsonResponseData = new StringBuffer();
			String readline = null;

			while((readline = in.readLine()) != null){
				jsonResponseData.append(readline);
			}

			in.close();
			JSONObject jsonObject = new JSONObject(jsonResponseData.toString());
			System.out.println(jsonObject);
//			formatted json
			System.out.println(jsonObject.toString(3));
		}else{
			System.out.println("This is not valid API");
		}

	}
}
