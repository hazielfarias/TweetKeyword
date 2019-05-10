package com.hazielfarias.twitterapp2.resouces;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hazielfarias.twitterapp2.repository.TweetRepository;

import twitter4j.TwitterException;


@RestController
@RequestMapping("/twitterapp")
public class TweetResources {
	
	@Autowired
	private TweetRepository tweetRepository; 
	
	@RequestMapping(method=RequestMethod.GET)
	public TweetResult main() throws TwitterException {
		
		TweetResult lista = new TweetResult("keyword teste");
		tweetRepository.saveAll(Arrays.asList(lista));
	    return lista;
	}
}
