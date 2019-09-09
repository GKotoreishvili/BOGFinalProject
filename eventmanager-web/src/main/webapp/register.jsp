<%@ page import="java.util.Map" %>
<%@ page import="ge.bog.eventmanager.core.CategoryAPI" %>
<%@ page import="ge.bog.eventmanager.core.CategoryManager" %>
<%@ page import="java.util.List" %>
<%@ page import="ge.bog.eventmanager.model.Category" %>
<form method="post" action="home" id="home_form">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="home"/>
    </jsp:include>
</form>
<div class="container-fluid heading">
    <h2>CREATE ACCOUNT</h2>
</div>
<div class="container">
    <div class="row justify-content-around">
        <div class="col-md-9 quiz_form">
            <form method="post" action="register" id="add_quiz_form">
                <div style="color: #ff0000;">${error}</div>
                <div class="form-group">
                    <label for="name">FirstName</label>
                    <input type="text" class="form-control" name="name" id="name" required>
                </div>
                <div class="form-group">
                    <label for="surname">LastName</label>
                    <textarea class="form-control" name="surname" id="surname" required></textarea>
                </div>
                <div class="form-group">
                    <label for="number">PhoneNumber</label>
                    <input type="text" class="form-control" name="number" id="number" required/>
                </div>
                <div class="form-group">
                    <label for="username">UserName</label>
                    <input type="text" class="form-control" name="username" id="username" required>
                </div>
                <div class="form-group">
                    <label for="password" class="form-group">Password: </label>
                    <input id="password" class="form-control" type="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="repeatpassword" class="form-group">Repeat Password: </label>
                    <input id="repeatPassword" class="form-control" type="password" name="repeatpassword" required>
                </div>
                <input type="hidden" name="practice" value="true" >
                <hr>
                <button type="submit" class="btn btn-primary btn-lg">register</button>
            </form>
        </div>
    </div>
</div>
