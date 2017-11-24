<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.content {
	display: flex;
	justify-content: center;
}
.imdb {
	text-align: center;
}
</style>
<title>Enjoy result</title>
</head>
<body>
	<header class="content">
		<a href="index.jsp">На главную</a>
	</header>
	<nav>
		<ul>
			<c:forEach begin="1" end="${requestScope.pagesAmount}" var="i">
				<li><a href="FrontController?parser_type=${param.parser_type }&page=${i}">${i}</a></li>
			</c:forEach>
		</ul>
	</nav>
	<div class="content">
		<table >
			<thead>
				<tr>
					<th>Название фильма на русском</th>
					<th>Оригинальное название</th>
					<th>Режиссер</th>
					<th>Актеры</th>
					<th>Жанр</th>
					<th>Страна</th>
					<th>Год</th>
					<th>Рейтинг IMDB</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="movie" items="${requestScope.movies}" begin="${requestScope.begin}" end="${requestScope.end}">
					<tr>
						<td>${movie.title.original}</td>
						<td>${movie.title.russian}</td>
						<td>${movie.director}</td>
						<td>${movie.actor}</td>
						<td>${movie.genre}</td>
						<td>${movie.country}</td>
						<td>${movie.year}</td>
						<td class="imdb">${movie.imdbRating}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>