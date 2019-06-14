package com.example.demo.com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "tweets")
public class TweetResult implements Serializable {
    String keyWords;
    Date dateTime;
    List<TweetData> results;
}
