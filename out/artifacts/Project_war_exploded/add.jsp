<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: miruna
  Date: 12.01.2020
  Time: 16:26
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
    <title>Add Remove</title>
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
<div class="container is-fluid ">

<%
Map<String, ArrayList<String>> queryq = (Map<String, ArrayList<String>>) session.getAttribute("result");
    ArrayList<String> jobs = queryq.get("jobs");
    ArrayList<String> names = queryq.get("names");
//    out.print(names);
    for (int i=0; i<jobs.size();i++) {
   %>
    <div class="container is-fluid ">
        <div class="level-item">
        <h3 style="font-weight: bold">Name:  </h3><h3><%out.print(names.get(i));%></h3>
        </div>
    <div class="level-item">
    <h3 style="font-weight: bold" class="job<%out.print(i);%>" id="<%out.print(i);%>">Job: </h3> <h3><%out.print(jobs.get(i));%></h3>
        <div class="level-item ">
        <form method="POST" action="${pageContext.request.contextPath}/add">
            <div class="form-group ">
                <h5>Add job</h5><input type="text" class="form-control"  placeholder="" name="job<%out.print(i);%>" label="job<%out.print(i);%>" >
                <h5>Modify job</h5><input type="text" class="form-control"  placeholder="" name="mod<%out.print(i);%>" label="mod<%out.print(i);%>" >
                <button type="submit" class="btn btn-primary">Submit</button>
            </div> </form>

        </div>
</div>


<% } %>



</body>
</html>
