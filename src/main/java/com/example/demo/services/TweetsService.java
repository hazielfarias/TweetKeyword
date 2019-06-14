package com.example.demo.services;

import com.example.demo.model.TweetData;
import com.example.demo.model.TweetResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TweetsService {
    @Value("${var.consumerkey}")
    String consumerKey;
    @Value("${var.consumersecret}")
    String consumerSecret;
    @Value("${var.token}")
    String token;
    @Value("${var.tokensecret}")
    String tokenSecret;



    public TweetData createTweet (String keyWords, Integer id) throws TwitterException {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(consumerKey);
        cb.setOAuthConsumerSecret(consumerSecret);
        cb.setOAuthAccessToken(token);
        cb.setOAuthAccessTokenSecret(tokenSecret);

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Query query = new Query(keyWords);
        QueryResult result = twitter.search(query);
        try {
            String url= "https://twitter.com/" + result.getTweets().
                    get(id).getUser().getScreenName()
                    + "/status/"
                    + result.getTweets().get(id).getId();
            return new TweetData(result.getTweets().get(id).getCreatedAt(),result.getTweets().get(id).getId(),result.getTweets().get(id).getText(),url);
        } catch (Exception e) {
            return null;
        }
    }

     public TweetResult searchKeyWord (String keyWord) throws TwitterException {

        List<TweetData> lista = new ArrayList<>();

        for (Integer x=0; x<10; x++){
            lista.add(createTweet(keyWord,x));
        }
        Date hoje = new Date();
        TweetResult resultado = new TweetResult(keyWord,hoje,lista);
        return resultado;
     }
}
