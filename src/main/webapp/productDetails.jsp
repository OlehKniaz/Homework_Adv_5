<%@ page import="entities.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Product Details</title>
    <link rel="stylesheet" href="./Css/productDetails.css" text="text/css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Passion+One&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Slab:wght@600&display=swap" rel="stylesheet">

<body>
<jsp:include page="header.jsp"/>

<%
    Product product = (Product) request.getAttribute("product");
    final String defaultImage = "http://localhost:8080/Homework_Adv_5_war_exploded/images/product-default.png";
%>

        <div class="small-container single-product">
            <img class="prododyct_img" src="<%= product.getImage() != null ? product.getImage() : defaultImage %>" alt="product" style="float: left; padding-top: 1%;
             padding-left: 4%; padding-right: 5%; padding-bottom: 1%" width="45%" height="75%"  id="ProductImg">
            <div style="padding-top: 8%">
                <h1 style="font-size: 72px; font-family: 'Righteous', cursive;"><%= product.getName()%></h1>
                <h3 style="font-size: 38px; padding-top: 1%; font-family: 'Passion One', cursive; color: #007214"><%= product.getPrice()%> $</h3>
                <input class="inp" type="number" value="1">

                <a href="#" style=" text-decoration: none;"><button class="byton">Buy product</button></a>

            </div>
            <div style=" padding-top: 12%; padding-left: 5%; padding-right: 4%;">
                <h2 style="font-size: 38px; padding-left: 4%; font-family: 'Righteous', cursive;">Product description</h2>
                <hr>
                <p style="font-size: 20px; font-family: 'Quicksand', sans-serif;"><%= product.getDescription()%></p>
                <hr>
            </div>

            <footer>
                <p style=" font-size: 15px; font-family: 'Quicksand', sans-serif;">Compani ©Borysov_Ihor. </p>
            </footer>
        </div>
</body>
</html>
