package twitter_test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

/**
 * Servlet implementation class TweetServlet
 */
@WebServlet("/TweetServlet")
public class TweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//サーブレットから検索画面を呼び出す
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		rd.forward(request, response);
	}
	//検索画面からpostメソッドで呼び出す
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//検索画面からの入力を取得し、値をセットする
		String searchWord  = request.getParameter("search");
//		System.out.println(searchWord);
		TweetBean tweet = new TweetBean();
		tweet.setSearchWord(searchWord);
		
//		GetTweet gettweet = new GetTweet();
//		try {
//			gettweet.execute();
//		} catch (TwitterException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
		
		List<String> text = new ArrayList<String>();
		List<User> user = new ArrayList<User>();
		List<Date> createdAt = new ArrayList<Date>();

		// 初期化
		Twitter twitter = new TwitterFactory().getInstance();
		Query query = new Query();

		// 検索ワードをセット
		query.setQuery(searchWord);

		// 検索実行
		QueryResult result = null;
		try {
		result = twitter.search(query);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
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
		
		//リクエストスコープに保存
		request.setAttribute("text",tweet.getText());
//		request.setAttribute("user",tweet.getUser());
		request.setAttribute("createdAt",tweet.getCreatedAt());
		
		//検索画面にフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		rd.forward(request, response);	
	}
}
