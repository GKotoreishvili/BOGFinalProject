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
    <h2>ADD EVENT</h2>
</div>
<div class="container">
    <div class="row justify-content-around">
        <div class="col-md-9 quiz_form">
            <form method="post" action="addevent" id="add_quiz_form">
                <div class="form-group">
                    <label for="name">Event Name</label>
                    <input type="text" class="form-control" name="name" id="name" required>
                </div>
                <div class="form-group">
                    <label for="description">Event Description</label>
                    <textarea class="form-control" name="description" id="description" required></textarea>
                </div>
                <div class="form-group">
                    <label for="image">Event Image</label>
                    <input type="text" class="form-control" name="image" id="image" required/>
                </div>
                <div class="form-group">
                    <label for="startdate">Start Date</label>
                    <input type="text" class="form-control" name="startdate" id="startdate" required>
                </div>
                <div class="form-group">
                    <label for="location">Location</label>
                    <input type="text" class="form-control" name="location" id="location" required>
                </div>
                <div class="form-group">
                    <label for="category">Choose Category</label>
                    <select id="category" name="category" class="form-control">
                        <% List<Category> categories = (List<Category>) request.getAttribute("categories");
                            for(Category category : categories) {%>
                        <option value="<%=category.getId()%>"><%=category.getName()%></option>
                        <% } %>
                    </select>
                </div>
                <input type="hidden" name="practice" value="true" >
                <hr>
                <button type="submit" class="btn btn-primary btn-lg">Add Event</button>
            </form>
        </div>
    </div>
</div>
