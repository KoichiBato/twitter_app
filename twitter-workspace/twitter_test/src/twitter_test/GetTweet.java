package twitter_test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class GetTweet {

	public void execute() throws TwitterException {
		List<String> text = new ArrayList<String>();
		List<User> user = new ArrayList<User>();
		List<Date> createdAt = new ArrayList<Date>();

		// 初期化
		Twitter twitter = new TwitterFactory().getInstance();
		Query query = new Query();

		// 検索ワードをセット
		TweetBean tweet = new TweetBean();
		query.setQuery(tweet.getSearchWord());

		// 検索実行
		QueryResult result = twitter.search(query);

		for (Status status : result.getTweets()) {
			// ツイートの数だけ本文、ユーザ、日時をリストに追加
			text.add(status.getText());
			user.add(status.getUser());
			createdAt.add(status.getCreatedAt());
		}
		//追加したリストをセット
		tweet.setText(text);
		tweet.setUser(user);
		tweet.setCreatedAt(createdAt);
	}
}