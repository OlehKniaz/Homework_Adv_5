<%--
  Created by IntelliJ IDEA.
  User: ibori
  Date: 11.07.2022
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Registrarion</title>
  <link rel="stylesheet" href="./Css/registration.css" text="text/css">
</head>
<body>
<div id="registration-form">
  <div class='fieldset'>
    <legend>Registration</legend>
    <form onsubmit="handleRegistration(event)" data-validate="parsley">
      <div class='row'>
        <label for='firstname'>First Name</label>
        <input type="text" placeholder="First Name" name='firstName' id='firstname'
               data-required="true" data-error-message="Your Last Name is required">
      </div>
      <div class='row'>
        <label for='lastname'>Last Name</label>
        <input type="text" placeholder="Last Name" name='lastName' id='lastname' data-required="true" data-error-message="Your First Name is required">
      </div>
      <div class='row'>
        <label for="email">E-mail</label>
        <input type="text" id="email" placeholder="E-mail"  name='email' data-required="true" data-type="email" data-error-message="Your E-mail is required">
      </div>
      <div class='row'>
        <label for="password">Password</label>
        <input type="password" id="password" placeholder="Password" name='password' data-required="true" data-error-message="Your E-mail must correspond">
      </div>
      <div id = "errorMessage" class = "errorMessage"></div>
      <input type="submit" value="Register">
    </form>
  </div>
</div>
<script src="js/from-handler.js"></script>
</body>
</html>
