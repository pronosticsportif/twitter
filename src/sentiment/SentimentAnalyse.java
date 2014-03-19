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

	
	public static void main(String[] args) throws Exception 
	{ 
		System.out.println("score :"+sentiment("real madrid joue très bien"));
	}
	private static String languageDetection(String str) throws Exception
	{
		
      
         
         DetectLanguage.apiKey = "1079d6ab1cfbd9e42247993601647e54";
         List<Result> results = DetectLanguage.detect(str);

         Result result = results.get(0);
         String lang =result.language;
     
		return lang;
		
	} 
	public static double sentiment(String str) throws Exception
	{
		String url = "http://sentimentanalyzer.appspot.com/api/classify.json";
		String lang=languageDetection(str);
		String data="{\"data\": [{\"content\": \""+str+"\", \"lang\": \""+lang+"\"}]}";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");

 
		con.setDoOutput(true);
		 OutputStream wr = con.getOutputStream();
		wr.write(data.getBytes("UTF-8"));
		wr.flush();
		//wr.close();
		if (con.getResponseCode() != 200) {
			 throw new RuntimeException("Failed : HTTP error code : "
					                     + con.getResponseCode());

		}
		//int responseCode = con.getResponseCode();
		BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
				                    (con.getInputStream())));

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
		            //JSONObject element = array.getJSONObject(0);
		           
		                JSONObject element = array.getJSONObject(0);
		             
		                System.out.println("score : "+element.get("score"));

		           
		         double score =(double) element.get("score");
		         if (score<0.5)score=1-score;
		            con.disconnect();
					return  score;

 
	}
		
	

}
