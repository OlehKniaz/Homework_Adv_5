<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="width: 70%; margin: 0 auto">
    <form onsubmit="handleCreateProduct(event)">
        <div class="mb-3">
            <label for="name" class="form-label">Prodyct Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea class="form-control" id="description" name="description" rows="3"></textarea>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price in $</label>
            <input type="number" min="1" class="form-control" id="price" name="price">
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">Image</label>
            <input type="file" min="1" class="form-control" id="image" name="image">
        </div>

        <input type="submit" class="btn btn-primary">
    </form>
</div>
<script src="js/from-handler.js"></script>
</body>
</html>
