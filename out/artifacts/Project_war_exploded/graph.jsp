<%--
  Created by IntelliJ IDEA.
  User: miruna
  Date: 12.01.2020
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%String graph = (String) request.getAttribute("graph");%>
    <img src="${pageContext.request.contextPath}/images/<%out.print(graph);%>" alt="image" style="width: 60%; height: 60%;">
    <a href="${pageContext.request.contextPath}/add" ><button class="button is-info is-rounded">Go to Add and Remove</button></a>
</body>
</html>
