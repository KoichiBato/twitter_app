package twitter_test;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import twitter4j.User;

public class TweetBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String searchWord;
	private List<String> text;
	private List<User> user;
	private List<Date> createdAt;
	
	public TweetBean() {}
	
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	public List<String> getText() {
		return text;
	}
	public void setText(List<String> text) {
		this.text = text;
	}
	
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	
	public List<Date> getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(List<Date> createdAt) {
		this.createdAt = createdAt;
	}
	
}
