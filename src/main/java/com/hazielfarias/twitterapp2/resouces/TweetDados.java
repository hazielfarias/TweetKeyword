package com.hazielfarias.twitterapp2.resouces;

import java.util.Date;

public class TweetDados {

	private Date Created_at;
	private long id;
	private String text;
	private String url;
	
	
	
	
	public TweetDados(Date created_at, long id, String text, String url) {
		super();
		Created_at = created_at;
		this.id = id;
		this.text = text;
		this.url = url;
	}
	public Date getCreated_at() {
		return Created_at;
	}
	public void setCreated_at(Date created_at) {
		Created_at = created_at;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
