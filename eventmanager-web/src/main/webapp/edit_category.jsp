<%@ page import="java.util.Map" %>
<%@ page import="ge.bog.eventmanager.core.CategoryAPI" %>
<%@ page import="ge.bog.eventmanager.core.CategoryManager" %>
<%@ page import="ge.bog.eventmanager.model.Category" %>

<%
    Category category = (Category) request.getAttribute("category");
    request.getSession().setAttribute("id", category.getId());
%>
<form method="post" action="home" id="home_form">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="home"/>
    </jsp:include>
</form>
<div class="container-fluid heading">
    <h2>Edit Category</h2>
</div>

<a href="deleteevent?id=<%=category.getId()%>"><button>delete</button></a>

<div class="container">
    <div class="row justify-content-around">
        <div class="col-md-9 quiz_form">
            <form method="post" action="editcategory" id="add_quiz_form">
                <div style="color: #ff0000;">${error}</div>
                <div class="form-group">
                    <label for="name">Category Name</label>
                    <input type="text" class="form-control" name="name" id="name" value=<%=category.getName()%> required>
                </div>
                <hr>
                <a href="editevent"><button>save</button></a>
            </form>
        </div>
    </div>
</div>
