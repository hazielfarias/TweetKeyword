package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
public class TweetData implements Serializable {
    Date created_at;
    long id;
    String text;
    String url;

}
