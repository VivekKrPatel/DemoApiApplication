package com.geekster.DemoApiApp3;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class DemoApiApp3Application{

	public static void main(String[] args) throws Exception{
		URL getUrl = new URL("https://api.nationalize.io/?name=nathaniel");
		HttpURLConnection urlConnection = (HttpURLConnection) getUrl.openConnection();
		urlConnection.setRequestMethod("GET");

		int responseCode = urlConnection.getResponseCode();

		if(responseCode == 200){
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			StringBuffer jsonResponseData = new StringBuffer();
			String readline = null;

			while((readline = in.readLine()) != null){
				jsonResponseData.append(readline);
			}

			in.close();
			JSONObject jsonObject = new JSONObject(jsonResponseData.toString());
			System.out.println(jsonObject);

//			Key Value pairs
			System.out.println(jsonObject.toString(2));
		}else{
			System.out.println("404 error found");
		}
	}

}
