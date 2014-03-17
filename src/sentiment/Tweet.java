package sentiment;

public class Tweet {
private int followersCount;
private String user;
private int retweetCount;
public Tweet(int followersCount, String user, int retweetCount) {
	
	this.followersCount = followersCount;
	this.user = user;
	this.retweetCount = retweetCount;
}
public int getFollowersCount() {
	return followersCount;
}
public void setFollowersCount(int followersCount) {
	this.followersCount = followersCount;
}
public int getRetweetCount() {
	return retweetCount;
}
public void setRetweetCount(int retweetCount) {
	this.retweetCount = retweetCount;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
}
