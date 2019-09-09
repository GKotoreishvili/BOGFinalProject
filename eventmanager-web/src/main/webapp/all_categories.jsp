<%@ page import="ge.bog.eventmanager.model.Category" %>
<%@ page import="java.util.List" %>
<form method="post" action="home" id="home_form">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="home"/>
    </jsp:include>
</form>
<table>
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
    </tr>

    </thead>

    <tbody>
    <% int count = 0; %>
    <% List<Category> list = (List<Category>) request.getAttribute("categories"); %>
    <% if (list != null) { %>
    <% for (Category category : list) { %>
    <tr>
        <% count++; %>
        <th scope="row"><%=count%>
        </th>
        <td><%=category.getName() %>
        </td>
        <td><a href="editcategory?id=<%=category.getId()%>"><button>edit</button></a>
        </td>
        <td><a href="deletecategory?id=<%=category.getId()%>"><button>delete</button></a>
        </td>
    </tr>
    <% } %>
    <% }%>
    </tbody>
    <a href="add_category.jsp"><button>Add Category</button></a>
</table>
