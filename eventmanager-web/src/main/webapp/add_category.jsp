<form method="post" action="home" id="home_form">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="home"/>
    </jsp:include>
</form>
<form method="post" action="addcategory" id="add_category_form">
    <div style="color: #ff0000;">${error}</div>
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" name="name" id="name" required>
    </div>
    <input type="hidden" name="practice" value="true" >
    <hr>
    <button type="submit" class="btn btn-primary btn-lg">Add</button>
</form>