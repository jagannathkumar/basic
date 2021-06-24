/**
 * 
 */
package com.myproject.apihitexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONObject;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author JK
 *
 */
public class GetData {
	public static void main(String[] args) throws MalformedURLException, RestClientException {
		System.setProperty("http.agent", "Chrome");
		try {
			// Using RestTemplate getting data
			/*
			 * RestTemplate restTmplate = new RestTemplate(); List<HttpMessageConverter<?>>
			 * converters = new ArrayList<HttpMessageConverter<?>>(); converters.add(new
			 * MappingJackson2HttpMessageConverter());
			 * restTmplate.setMessageConverters(converters);
			 * 
			 * PageData pageData =
			 * restTmplate.getForObject("https://reqres.in/api/users?page=1",PageData.class)
			 * ; for(UserData data: pageData.getUserData()) {
			 * System.out.println("Email: "+data.getEmail()+", Name: "+data.getName()); }
			 */

			// Using ObjectMapper and inputstream getting data
			int count = 2;
			List<UserData> result = new ArrayList<UserData>();
			while (count > 0) {
				URL url = new URL("https://reqres.in/api/users?page="+count);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String output = br.readLine();
				ObjectMapper obj = new ObjectMapper();
				obj.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
				PageData pageData = obj.readValue(output, PageData.class);
				System.out.println(pageData.getPage() + " " + pageData.getTotal_pages());
				for (UserData data : pageData.getUserData()) {
					if(data.getName().startsWith("E"))
						result.add(data);
					System.out.println("Email: " + data.getEmail() + ", Name: " + data.getName());
				}
				conn.disconnect();
				br.close();
				count--;
			}
			result.stream().forEach(x->{System.out.println(x.getName());});
			System.out.println(result.stream().mapToInt(x->x.getId()).average());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class PageData {
	private int page;
	private int per_page;
	private int total_pages;
	@JsonProperty("data")
	private List<UserData> userData;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public List<UserData> getUserData() {
		return userData;
	}

	public void setUserData(List<UserData> userData) {
		this.userData = userData;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class UserData {
	@JsonProperty("id")
	private int id;
	@JsonProperty("email")
	private String email;
	@JsonProperty("first_name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}