<%@ page import="ge.bog.eventmanager.core.EventAPI" %>
<%@ page import="ge.bog.eventmanager.core.EventManager" %>
<%@ page import="ge.bog.eventmanager.model.Event" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<div class="cover">
    <div class="hero-text">
        <a href="login.jsp" class="btn btn-danger btn-lg">LOG IN</a>
        <a href="register.jsp" class="btn btn-danger btn-lg">SIGN UP</a>
    </div>
</div>
<div style="text-align: center; font-size:40px; padding: 20px">
            Event Manager
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
            <% List<Event> list = (List<Event>) request.getAttribute("events"); %>
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
                <%
                    if (event.getStartDate().compareTo(new Date()) > 0) {
                        continue;
                    }
                %>
                <td><a href="editdispatcher?id=<%=event.getId()%>"><button>edit</button></a>
                </td>
                <td><a href="deleteevent?id=<%=event.getId()%>"><button>delete</button></a>
                </td>
            </tr>
            <% } %>
            <% } %>
            </tbody>

        </table>
    <form method="post" action="dispatcher" id="remove_quiz">
        <input type = "submit" value = "Add Event" />
    </form>
</div>
