package com.hazielfarias.twitterapp2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends MongoRepository<TweetResult, String>{

}
