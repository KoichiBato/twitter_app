<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Twitter検索</title>
</head>
<body>
<h2>Twitter検索ページ</h2>
<form action="/twitter_test/TweetServlet" method="post">
<input type="text" name="search"><input type="submit" value="検索">
</form>
</body>
</html>