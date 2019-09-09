<%@ page import="ge.bog.eventmanager.core.EventAPI" %>
<%@ page import="ge.bog.eventmanager.core.EventManager" %>
<%@ page import="ge.bog.eventmanager.model.Event" %>
<%@ page import="java.util.List" %>
<form method="post" action="home" id="home_form">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="home"/>
    </jsp:include>
</form>
<div style="text-align: center; font-size:40px; padding: 20px">

    <table>
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Image</th>
            <th scope="col">Location</th>
            <th scope="col">StartDate</th>
            <th scope="col">CreatDate</th>
            <th scope="col">CategoryName</th>
        </tr>

        </thead>

        <tbody>
        <% int count = 0; %>
        <% List<Event> list = (List<Event>) request.getAttribute("userevents"); %>
        <% if (list != null) { %>
        <% for (Event event : list) { %>
        <tr>
            <% count++; %>
            <th scope="row"><%=count%>
            </th>
            <td><%=event.getName() %>
            </td>
            <td><%=event.getDescription() %>
            </td>
            <td><%=event.getImageUrl()%>
            </td>
            <td><%=event.getLocation()%>
            </td>
            <td><%=event.getStartDate()%>
            </td>
            <td><%=event.getCreateDate()%>
            </td>
            <td><%=event.getCategory().getName()%>
            </td>
        </tr>
        <% } %>
        <% } %>
        </tbody>

    </table>
</div>
