package com.example.demo.repository;

import com.example.demo.model.TweetResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetsRepository extends MongoRepository <TweetResult,String> {
}
