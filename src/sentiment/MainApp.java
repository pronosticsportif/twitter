package sentiment;   
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException; 
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
public class MainApp {
	public static void main(String[] args) throws TwitterException, IOException 
	{ 
		  
		final String CONSUMER_KEY = "vprCl3FLapuJjQaSspXlng";
		final String CONSUMER_SECRET = "l2U62jDHvF2lQpNxa9sHwUQTVJQ2BIV0Ei2Y4mtBOo";  
		final String ACCESS_TOKEN = "272657997-qLmvO2QkcTIHkReUDJz5ZjMPVs7Fva4T9Bo4GvB3"; 
		final String ACCESS_TOKEN_SECRET = "vZiIg3d0DPG3o9wfZkkUC6RLMoHKcfDDAoClLhSHAIvPH";   
		
		final PrintWriter fichier1 = new PrintWriter(new FileWriter("BayernVsReal3.txt"));
		final PrintWriter fichier2 = new PrintWriter(new FileWriter("BestTweetBayern.txt"));
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(CONSUMER_KEY)
		  .setOAuthConsumerSecret(CONSUMER_SECRET)
		  .setOAuthAccessToken(ACCESS_TOKEN)
		  .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
		
		 TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
		final  int maxJeton = 0 ;
		StatusListener listener = new StatusListener(){
	        public void onStatus(Status status) {
	           
	            // ecriture fichier
	          	   
	   
	            try {
	             
                 
                	 
                	 if(status.isRetweet() == false)
                	 {	 
                	 if(status.getIsoLanguageCode().compareTo("es") == 0  )      
                     {
	   		     	 fichier1.write(SentimentAnalyse.sentimentSpanish(status.getText()) +","+SystemJeton.getJetonsFonction(FreeBase.isJournaliste(status.getUser().getName()))+','+ SystemJeton.getJetonsFollowers(status.getUser().getFollowersCount()) + '\n');
	                 
	   		     fichier1.flush();
	   		 
                     }
                	 else 
                	 {
                		 fichier1.write(SentimentAnalyse.sentiment(status.getText(),status.getIsoLanguageCode()) +","+SystemJeton.getJetonsFonction(FreeBase.isJournaliste(status.getUser().getName()))+','+ SystemJeton.getJetonsFollowers(status.getUser().getFollowersCount()) + '\n');
                		 
        	   		     fichier1.flush(); 
        	   		     
        	   		     if(SystemJeton.getJetonsFollowers(status.getUser().getFollowersCount()) + SystemJeton.getJetonsFonction(FreeBase.isJournaliste(status.getUser().getName())) >= 14)
        	   		     {
        	   		    	 fichier2.write(status.getText() +", score Jetons = "+SystemJeton.getJetonsFonction(FreeBase.isJournaliste(status.getUser().getName())) + SystemJeton.getJetonsFollowers(status.getUser().getFollowersCount()) + '\n');
                    		 
            	   		     fichier2.flush(); 
        	   		    	 
        	   		    	 
        	   		     }
                	 }
                	 }
	   		    } catch 
	   		    (Exception e) {
	   		      e.printStackTrace();
	   		    } 
	            //
	            
	            // FreeBase
	        	
	            
	        
	        }
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }
			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}
	    };
	    FilterQuery fq = new FilterQuery();
	    String keywords[] = {"Bayern Munich","Bayern"};
	    fq.track(keywords);
	    twitterStream.addListener(listener);
	    twitterStream.filter(fq);
		
		
	

	}
	
}
 