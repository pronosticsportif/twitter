package sentiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import twitter4j.TwitterException;




public class FreeBase {
	private static final String API_KEY = "AIzaSyA9fEFmKg6upMuQ3PD7gy4Ojlpe72xfbDM";

	
	public static String isJournaliste(String nom) throws ClientProtocolException, IOException, ParseException, org.json.simple.parser.ParseException{
	
	DefaultHttpClient httpclient = new DefaultHttpClient();
	JSONParser parser = new JSONParser();

	List<NameValuePair> params = new ArrayList<NameValuePair>();
	params.add(new BasicNameValuePair("query", nom));
	params.add(new BasicNameValuePair("key", API_KEY));

	String serviceURL = "https://www.googleapis.com/freebase/v1/search";
	String url = serviceURL + "?" + URLEncodedUtils.format(params, "UTF-8");      
	HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
	JSONObject response = (JSONObject)parser.parse(EntityUtils.toString(httpResponse.getEntity()));
	
	if(response.get("result").toString().contains("Journalist") ||  response.get("result").toString().contains("Sports commentator")  )
	
		return "Journalist" ;
	
	if(response.get("result").toString().contains("Professional Association Football Player"))
		
		return "Professional Association Football Player";
	
	else 
			return "fan" ;
	

	}
	public static void main(String[] args) throws TwitterException, ClientProtocolException, ParseException, IOException, org.json.simple.parser.ParseException 
	{ 
		
		
	}
}
