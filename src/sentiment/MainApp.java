package sentiment;   
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
	public static void main(String[] args) throws TwitterException 
	{  
		  
		final String CONSUMER_KEY = "vprCl3FLapuJjQaSspXlng";
		final String CONSUMER_SECRET = "l2U62jDHvF2lQpNxa9sHwUQTVJQ2BIV0Ei2Y4mtBOo";  
		final String ACCESS_TOKEN = "272657997-bBSRUy10uOQUOoKkydL4j08iyzijSMWnLWbpDKSU"; 
		final String ACCESS_TOKEN_SECRET = "4lFodoqwdkyGmON0oAFgkHlXYj3eh4d4Tzy2Z1wqa0A";   
		   
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(CONSUMER_KEY)
		  .setOAuthConsumerSecret(CONSUMER_SECRET)
		  .setOAuthAccessToken(ACCESS_TOKEN)
		  .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
		
		 TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
		 
		StatusListener listener = new StatusListener(){
	        public void onStatus(Status status) {
	            System.out.println(status.getUser().getFollowersCount() + " : " + status.getText());
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
	    String keywords[] = {"real madrid","cr7"};
	    fq.track(keywords);
	    twitterStream.addListener(listener);
	    twitterStream.filter(fq);
		
		
	

	}
}
 