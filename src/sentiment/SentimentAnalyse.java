package sentiment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;

public class SentimentAnalyse {

	

	public static String languageDetection(String str) throws Exception {
		DetectLanguage.apiKey = "1079d6ab1cfbd9e42247993601647e54";
		List<Result> results = DetectLanguage.detect(str);

		Result result = results.get(0);
		String lang = result.language;

		return lang;

	}

	public static int sentiment(String str , String langue) throws Exception {
		
		String url = "http://sentimentanalyzer.appspot.com/api/classify.json";
	
		String data = "{\"data\": [{\"content\": \"" + str + "\", \"lang\": \""
				+ langue + "\"}]}";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");

		con.setDoOutput(true);
		OutputStream wr = con.getOutputStream();
		wr.write(data.getBytes("UTF-8"));
		wr.flush();
		// wr.close();
		if (con.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ con.getResponseCode());

		}
		// int responseCode = con.getResponseCode();
		BufferedReader responseBuffer = new BufferedReader(
				new InputStreamReader((con.getInputStream())));

		System.out.println("\nSending 'POST' request to URL : " + url);
		StringBuffer result = new StringBuffer();
		String output;
		System.out.println("Output from Server:\n");
		while ((output = responseBuffer.readLine()) != null) {
			// System.out.println(output);
			result.append(output);
		}
		System.out.println(result.toString());
		JSONObject o = new JSONObject(result.toString());
		JSONArray array = new JSONArray(o.get("data").toString());
		// JSONObject element = array.getJSONObject(0);

		JSONObject element = array.getJSONObject(0);

		System.out.println("score : " + element.get("score"));

		double score = (double) element.get("score");
		int scoref ;
		if (score < 0.5)
			scoref = -1;
		else 
			scoref = 1 ;
		con.disconnect();
		return scoref;

	}

	public static int sentimentSpanish(String str) throws Exception {
		String url = "http://www.sentiment140.com/api/bulkClassifyJson";
		

		String data = "{\"lan'uage\": \"auto\" , \"data\": [{\"text\": \""
				+ str + "\"}]}";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");

		con.setDoOutput(true);
		OutputStream wr = con.getOutputStream();
		wr.write(data.getBytes());
		wr.flush();
		// wr.close();
		if (con.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ con.getResponseCode());

		}
		// int responseCode = con.getResponseCode();
		BufferedReader responseBuffer = new BufferedReader(
				new InputStreamReader((con.getInputStream())));

	
		StringBuffer result = new StringBuffer();
		String output;
		
		while ((output = responseBuffer.readLine()) != null) {
			// System.out.println(output);
			result.append(output);

		}
		

		JSONObject o = new JSONObject(result.toString());
		JSONArray array = new JSONArray(o.get("data").toString());
		// JSONObject element = array.getJSONObject(0);

		JSONObject element = array.getJSONObject(0);

		System.out.println("score : " + element.get("polarity"));

		int score = (int) element.get("polarity");

		con.disconnect();
		responseBuffer.close();
		if(score == 0)
			score = -1 ;
		else if (score == 4)
			score = 1 ;
		return score;

	}

	public static String encode(String str) {

		str = str.replace("#", "%23");
		str = str.replace(" ", "%20");
		str = str.replace("$", "%24");
		str = str.replace("&", "%26");
		str = str.replace("+", "%2B'");
		str = str.replace(",", "%2C");
		str = str.replace("/", "%2F");
		str = str.replace("\\", "%5C");
		str = str.replace(":", "%3A");
		str = str.replace(";", "%3B");
		str = str.replace("=", "%3D");
		str = str.replace("?", "%3F");
		str = str.replace("@", "%40");
		str = str.replace("[", "%5B");
		str = str.replace("]", "%5D");
		str = str.replace(">", "%3E");
		str = str.replace("<", "%3C");

		return str;
	}

}
