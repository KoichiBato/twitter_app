<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="twitter_test.TweetBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="twitter4j.User" %>

<%
//リクエストスコープに保存されたリストを取得
List<String> text = (List<String>) request.getAttribute("text");
List<Date> createdAt = (List<Date>) request.getAttribute("createdAt");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Twitter検索結果</title>
</head>
<body>
<h2>Twitter検索結果ページ</h2>
<table border="1">
<tr><th>ツイート</th><th>日時</th></tr>
<% for(int i = 0; i < text.size(); i++) { %>
	<tr>
		<td><%=text.get(i) %></td>
		<td><%=createdAt.get(i) %></td>
	</tr>
<% } %>
</table>
</body>
</html>