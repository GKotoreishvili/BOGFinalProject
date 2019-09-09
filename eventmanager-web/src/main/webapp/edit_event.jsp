<%@ page import="java.util.Map" %>
<%@ page import="ge.bog.eventmanager.core.CategoryAPI" %>
<%@ page import="ge.bog.eventmanager.core.CategoryManager" %>
<%@ page import="java.util.List" %>
<%@ page import="ge.bog.eventmanager.model.Category" %>
<%@ page import="ge.bog.eventmanager.model.Event" %>

<%
    Event event = (Event) request.getAttribute("event");
    request.getSession().setAttribute("id", event.getId());
%>
<form method="post" action="home" id="home_form">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="home"/>
    </jsp:include>
</form>
<div class="container-fluid heading">
    <h2>ADD EVENT</h2>
</div>

<a href="deleteevent?id=<%=event.getId()%>"><button>delete</button></a>

<div class="container">
    <div class="row justify-content-around">
        <div class="col-md-9 quiz_form">
            <form method="post" action="editevent" id="add_quiz_form">
                <div style="color: #ff0000;">${error}</div>
                <div class="form-group">
                    <label for="name">Event Name</label>
                    <input type="text" class="form-control" name="name" id="name" value=<%=event.getName()%> required>
                </div>
                <div class="form-group">
                    <label for="description">Event Description</label>
                    <textarea class="form-control" name="description" id="description" value=<%=event.getDescription()%> required></textarea>
                </div>
                <div class="form-group">
                    <label for="image">Event Image</label>
                    <input type="text" class="form-control" name="image" id="image" value=<%=event.getImageUrl()%> required/>
                </div>
                <div class="form-group">
                    <label for="startdate">Start Date</label>
                    <input type="text" class="form-control" name="startdate" id="startdate" value=<%=event.getStartDate()%> required>
                </div>
                <div class="form-group">
                    <label for="location">Location</label>
                    <input type="text" class="form-control" name="location" id="location" value=<%=event.getLocation()%> required>
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
                <hr>
                <a href="editevent"><button>save</button></a>
            </form>
        </div>
    </div>
</div>
