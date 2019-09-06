package ge.bog.eventmanager.web.servlets.eventservlets;

import ge.bog.eventmanager.core.CategoryAPI;
import ge.bog.eventmanager.core.EventAPI;
import ge.bog.eventmanager.core.UserAPI;
import ge.bog.eventmanager.model.Category;
import ge.bog.eventmanager.model.Event;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("addevent")
public class AddEvent extends HttpServlet {

    @Inject
    private EventAPI eventAPI;

    @Inject
    private CategoryAPI categoryAPI;

    @Inject
    private UserAPI userAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errors = "";

        String name = req.getParameter("name");
        if (name == null || name.length() < 1) errors += "<p class='error'>Title is Required</p>";
        System.out.println(name);

        String description = req.getParameter("description");
        if (description == null || description.length() < 1) errors += "<p class='error'>Description is Required</p>";
        System.out.println(description);

        String image = req.getParameter("image");
        if (image == null || image.length() < 1) errors += "<p class='error'>Image is Required</p>";
        System.out.println(image);

        String date = req.getParameter("startdate");
        if (date == null || date.length() < 1) errors += "<p class='error'>Start date is Required</p>";
        System.out.println(date);

        String location = req.getParameter("location");
        if (location == null || location.length() < 1) errors += "<p class='error'>Start date is Required</p>";
        System.out.println(location);

        int categoryId = -1;
        String category = req.getParameter("category");
        if (category == null || category.length() < 1) {
            errors += "<p class='error'>Start date is Required</p>";
        } else {
            categoryId = Integer.parseInt(category);
        }
        System.out.println(categoryId);

        if (errors.length() > 0) {
            resp.sendRedirect("add_event.jsp?error" + errors);
            return;
        }

        Category category1 = categoryAPI.getCategory(categoryId);

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

        Date startDate = null;
        try {
            startDate = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(startDate);

        eventAPI.addEvent(new Event(name, description, startDate, image, location, category1, userAPI.getUser(1)));
        resp.sendRedirect("indexservlet?success=You have successfully created event!");
    }
}
