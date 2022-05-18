package com.assignment.backend;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.imageio.ImageIO;

import org.json.JSONException;
import org.json.JSONObject;

/*The Image Finder class searches for an image online using the Web Search API by Roi Kravoski,
 * a GET request is sent and a JSON file is returned, it is then parsed using the Org.JSON
 * and the URL object is downloaded
 */
public class ImageFinder {
	
	//Reference: https://rapidapi.com/contextualwebsearch/api/web-search?endpoint=apiendpoint_2799d2c8-3abb-4518-a544-48d2c32d6662
	public static String getImage(String imageSearch) throws IOException, InterruptedException {
		
		if (imageSearch == null) throw new IllegalArgumentException("Image Search Must Be A String");
		
		//Create a GET request and receive JSON file with information
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/ImageSearchAPI?q=" + imageSearch.replaceAll("\\s+","%20") + "&pageNumber=1&pageSize=10&autoCorrect=true"))
				.header("X-RapidAPI-Host", "contextualwebsearch-websearch-v1.p.rapidapi.com")
				.header("X-RapidAPI-Key", "687f54e0ebmshdd21393802ae2f4p13487fjsn4a899a299493")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		
		return response.body();
		
		
	}
	
	//Write the image to the local project file so that it can also be accessible by the user
	public static void writeImageToProject(BufferedImage image) throws IOException
	{
		if (image == null) throw new IllegalArgumentException("Image Must Be Of Type BufferedImage");
		
		ImageIO.write(image, "jpg",new File("./TemporaryImage.jpg"));
	}
	
	public static BufferedImage ParseImageJSON(String json) throws MalformedURLException, JSONException, IOException
	{
		if (json == null) throw new IllegalArgumentException("JSON Must Be Of Type String");
		
		JSONObject obj = new JSONObject(json);
		return ImageIO.read(new URL(obj.getJSONArray("value").getJSONObject(0).getString("url")));
	}
}
