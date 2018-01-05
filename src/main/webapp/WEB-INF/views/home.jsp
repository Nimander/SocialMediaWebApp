<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Programik</title>

</head>
<body>
<c:forEach items="${comments}" var="comments">
	<b>${comments.userName}</b>
	<font size="1"> <i>${comments.timestamp}</i></font><br/>
	${comments.message}<br/><br/>
</c:forEach>


<a href="/login">Zaloguj</a> się aby dodawać komentarze
</body>
</html>
