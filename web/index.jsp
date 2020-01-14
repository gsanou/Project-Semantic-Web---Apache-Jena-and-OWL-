<%--
  Created by IntelliJ IDEA.
  User: miruna
  Date: 12.01.2020
  Time: 11:52
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
  <title>Hello</title>
</head>
  <body>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="http://localhost/index.php">All options</a>
      <a class="nav-link" href="http://localhost/logout.php">Logout</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
  </nav>
  <div class="container is-fluid ">
    <div class="level-item has-text-centered">
      <form method="POST" action="upload" enctype="multipart/form-data" >
        File:
        <input type="file" name="file" id="file" /> <br/>
        Destination:
        <input type="text" value="/home/miruna/Documents/Project" name="destination"/>
        </br>
        <input type="submit" value="Upload" name="upload" id="upload" />
      </form>
    </div>
  </body>
</html>
