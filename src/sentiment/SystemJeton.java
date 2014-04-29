package sentiment;

public class SystemJeton {
   
    
    // critére Globaux 
    public static int getJetonsFollowers(int valeur)
    {
    		if(valeur <= 100 )
    		  return 1 ;
    		else if( valeur > 100 && valeur <= 1000 )
    					return 4 ;
    		else if( valeur > 1000 && valeur < 10000 )
    			return 6 ;
    		else if( valeur >10000 && valeur < 100000)
    			return 8 ;
    		else if( valeur > 100000)
    			return 10 ;
    		else 
    			return -1 ;
   
    }
    
    public static int getJetonsFonction(String fonction)
    {
    	if(fonction == "fan")
    		return 1 ;
    	else if(fonction == "Journalist" )
    		return 10 ;
    	else if (fonction =="Professional Association Football Player")
    	    return 5 ;
    	else 
    		return -1 ;
    }
   
    public static int getjetonsRetweets(int retweets)
    {
    	
    	if(retweets == 0)
    		return 0 ;
    	else if (retweets > 0 && retweets <= 5 )
    		return 1;
    	else if(retweets > 5 && retweets <= 10)
    		return 2;
    	else if (retweets > 10 && retweets <= 20)
    		return 3 ;
    	else if (retweets > 20 && retweets <= 50  )
    		return 4 ;
    	else if(retweets > 50 && retweets <= 100)
    		return 6 ;
    	else if(retweets > 100 && retweets <= 500)
    		return 8 ;
    	else 
    		return 10 ;
    		
    }
    // Critére par rapport au football 
  
    public int getJetonsPalmares(String team)
    {
    	if(team == "Real Madrid" || team == "Real" || team == "RM" || team == "real madrid")
    		return 10;  // car le Real Madrid a remporter la champions league 9 fois 
    	
    	else if(team =="barca"|| team == "FCB" || team == "barcelona" || team == "FC BARCA")
    		return 8;  // car le FCB a remporter la ligue des champion 4 fois
    	
    	else if(team == "Atletico MAdrid")
    		return 1 ; // car Atletico n'a jamais eu de champions league
    	
    	else if (team == "Chelsea")
    		return 5 ; // car Chelsea a eu la champions league 1 seule fois
    	
    	else if(team == "Bayern Munich")
    		return 8 ; // le bayern a eu la champions league 5 fois 
    	
    	else if(team == "Manchester United")
    		return 5 ;
    	else 
    		return 0 ;
    }

	public int getJetonsLastFinalistes(String team)
	{
		if(team == "Bayren Munich")
	        return 10 ;
		else if(team == "chelsea")
			return 8 ;
		else if(team == "barca")
			return 6 ;
		else if (team == "manchester united")
			return 4 ;
		else  
			return 0 ;

	}
	
}
