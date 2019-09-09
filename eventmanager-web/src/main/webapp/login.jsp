<form method="post" action="home" id="home_form">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="home"/>
    </jsp:include>
</form>
<form method="post" action="login" id="log_in_form">
    <div style="color: #ff0000;">${error}</div>
    <div class="form-group">
        <label for="username">UserName</label>
        <input type="text" class="form-control" name="username" id="username" required>
    </div>
    <div class="form-group">
        <label for="password" class="form-group">Password: </label>
        <input id="password" class="form-control" type="password" name="password" required>
    </div>
    <button type="submit" class="btn btn-primary btn-lg">log in</button>
</form>