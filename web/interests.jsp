<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: miruna
  Date: 14.01.2020
  Time: 00:20
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
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="http://localhost/index.php">Project Semantic Web</a>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/graph.jsp">All options</a>
        <a class="nav-link" href="http://localhost/logout.php">Logout</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="level-item">
        <a href="${pageContext.request.contextPath}/add" ><button class="button is-info is-rounded">Go to Add and Remove</button></a>
        <a href="${pageContext.request.contextPath}/graduate" ><button class="button is-info is-rounded">Go to Graduate</button></a>
        <a href="${pageContext.request.contextPath}/profession" ><button class="button is-info is-rounded">Go to Profession</button></a>
        <a href="${pageContext.request.contextPath}/interests" ><button class="button is-info is-rounded">Go to Interests</button></a>
        <a href="${pageContext.request.contextPath}/sparql" ><button class="button is-info is-rounded">Go to Run Sparql</button></a>
        <a href="${pageContext.request.contextPath}/reasoner" ><button class="button is-info is-rounded">Go to Run Reasoner</button></a>
    </div>
</nav>
<% ArrayList<String> names = (ArrayList<String>) session.getAttribute("resultq5");
    for (int i=0; i<names.size();i++) {
%>
<div class="container is-fluid ">
    <div class="level-item">
        <h3 style="font-weight: bold">Name:  </h3><h3><%out.print(names.get(i));%></h3>
    </div>
        <%}%>

</body>
</html>
