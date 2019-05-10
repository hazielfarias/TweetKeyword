package com.hazielfarias.twitterapp2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hazielfarias.twitterapp2.resouces.TweetResult;

@Repository
public interface TweetRepository extends MongoRepository<TweetResult, String>{

}
