package com.myproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author JK
 *
 */
public class Mainclass {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/ticketshere/getLang");
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			// System.out.println("o/p:" + br.readLine());
			String output = br.readLine();
			System.out.println(output);
			ObjectMapper obj = new ObjectMapper();
			// String json = "{ \"id\" : \"1\", \"language\" : \"Hindi\" }";
			// Language lan = obj.readValue(json, Language.class);
			obj.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
			
			Language[] lang = obj.readValue(output, Language[].class);
			for (Language lan : lang)
				System.out.println(lan.getId() + " " + lan.getLanguage());
			List<Language> list1 = obj.readValue(output, new TypeReference<List<Language>>(){});
			list1.forEach(x->{System.out.println(x.getId()+" "+x.getLanguage());});
			conn.disconnect();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
