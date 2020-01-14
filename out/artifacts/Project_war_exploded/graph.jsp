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
    <style>
        /* [1] The container */
        /*.img-hover-zoom {*/
            /*height: 3000px; !* [1.1] Set it as per your need *!*/
        /*    overflow: hidden; !* [1.2] Hide the overflowing of child elements *!*/
        /*}*/

        /* Point-zoom Container */
        /*.img-hover-zoom--point-zoom img {*/
        /*    transform-origin: 25% 55%;*/
        /*    transition: transform 1s, filter .5s ease-out;*/
        /*}*/

        /*!* The Transformation *!*/
        /*.img-hover-zoom--point-zoom:hover img {*/
        /*    transform: scale(3);*/
        /*}*/
    </style>
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
</nav>
<%String graph = (String) session.getAttribute("graph");%>
<div class="container is-fluid ">
    <div class="level-item">
        <a href="${pageContext.request.contextPath}/add" ><button class="button is-info is-rounded">Go to Add and Remove</button></a>
        <a href="${pageContext.request.contextPath}/graduate" ><button class="button is-info is-rounded">Go to Graduate</button></a>
        <a href="${pageContext.request.contextPath}/profession" ><button class="button is-info is-rounded">Go to Profession</button></a>
        <a href="${pageContext.request.contextPath}/interests" ><button class="button is-info is-rounded">Go to Interests</button></a>
        <a href="${pageContext.request.contextPath}/sparql" ><button class="button is-info is-rounded">Go to Run Sparql</button></a>
        <a href="${pageContext.request.contextPath}/reasoner" ><button class="button is-info is-rounded">Go to Run Reasoner</button></a>
    </div>
<div class="img-hover-zoom--point-zoom">
    <img src="${pageContext.request.contextPath}/images/<%out.print(graph);%>" alt="image" >
<%--    ="width: 100%; height: 100%;">--%>
</div>


</div>
</body>
</html>
