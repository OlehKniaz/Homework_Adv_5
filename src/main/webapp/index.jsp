<html>
<head>
    <title>Store</title>
    <link rel="stylesheet" href="./Css/index.css" text="text/css">

</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div class="album py-5 bg-light">
        <div class="container-fluid" >
            <div class="row row-cols-1 row-cols-sm-3 row-cols-md-4 g-4" id="content">

            </div>
        </div>
    </div>

</main>

<script>
    let item = localStorage.getItem("userId");
    const idFromSession = <%= session.getAttribute("id")%>
    if(idFromSession !== item){
        localStorage.setItem("userId", idFromSession);
    }
</script>

<script src="./js/product.js"></script>

</body>
</html>
