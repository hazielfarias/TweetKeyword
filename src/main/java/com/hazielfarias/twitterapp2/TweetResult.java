package com.hazielfarias.twitterapp2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;



@Document(collection="tweets")
public class TweetResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String keywords;
	private Date dateTime;
	private List<TweetDados> results;
	
	public TweetResult(String keywords) throws TwitterException {
		super();
		this.keywords = keywords;
		this.dateTime = new Date();
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("G8fmFzwah9N0bmc3rihi9r6ko");
		cb.setOAuthConsumerSecret("36jYOaqMPDpoZVtOAFtk1cagf5KxG9TAkzDOLmOJgMVWdO1ACb");
		cb.setOAuthAccessToken("1122961205684051968-HLqWT9oEosBfU7zktpI1LzGcIQuFz4");
		cb.setOAuthAccessTokenSecret("07XJ7AHftI0jgpHTPOrrbedjYUac7XnK6giSSIrtqKtbY");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		Query query = new Query("eu amo");
	    QueryResult result = twitter.search(query);
	    List<TweetDados> lista = new ArrayList<>();
	    
	   int x =0;
	   String url;
	   TweetDados a;
	   		while (x<=10) {
	    	url= "https://twitter.com/" + result.getTweets().get(x).getUser().getScreenName() + "/status/" + result.getTweets().get(x).getId();
	    	a = new TweetDados(result.getTweets().get(x).getCreatedAt(),result.getTweets().get(x).getId(),result.getTweets().get(x).getText(),url);
	    	lista.add(a);
	    	x++;
	   		}	 
	    	//url= "https://twitter.com/" + result.getTweets().get(x).getUser().getScreenName() + "/status/" + result.getTweets().get(x).getId();
	    	 //a = new TweetDados(result.getTweets().get(x).getCreatedAt(),result.getTweets().get(x).getId(),result.getTweets().get(x).getText(),url);
	    	//lista.add(a);
	    	
	    	this.results = lista;
		
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public List<TweetDados> getResults() {
		return results;
	}

	public void setResults(List<TweetDados> results) {
		this.results = results;
	}
	
	

}
