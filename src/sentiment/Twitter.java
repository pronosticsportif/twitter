package sentiment;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class Twitter {
public static void main(String[] args) {
    	
        ConfigurationBuilder cb = new ConfigurationBuilder();
        

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

        StatusListener listener = new StatusListener() {

            @Override
            public void onException(Exception arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStatus(Status status) {
                User user = status.getUser();
                
                // gets Username
                int username = status.getUser().getFollowersCount();
                System.out.println(username);
                String profileLocation = user.getLocation();
                System.out.println(profileLocation);
               
                String content = status.getText();
                System.out.println(content +"\n");
                 
                  
                System.out.println("retweet : " + status.getRetweetedStatus().getRetweetCount());
            }

            @Override
            public void onTrackLimitationNotice(int arg0) {
                // TODO Auto-generated method stub

            }

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}

        };
        FilterQuery fq = new FilterQuery();
    
        String keywords[] = {"Real Madrid"};

        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);  
}
}