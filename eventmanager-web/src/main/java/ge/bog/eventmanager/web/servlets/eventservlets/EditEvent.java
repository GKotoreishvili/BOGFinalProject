package ge.bog.eventmanager.web.servlets.eventservlets;

import ge.bog.eventmanager.core.CategoryAPI;
import ge.bog.eventmanager.core.EventAPI;
import ge.bog.eventmanager.core.UserAPI;
import ge.bog.eventmanager.model.Category;
import ge.bog.eventmanager.model.Event;
import ge.bog.eventmanager.model.User;

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

@WebServlet("editevent")
public class EditEvent extends HttpServlet {

    @Inject
    private EventAPI eventAPI;

    @Inject
    private CategoryAPI categoryAPI;

    @Inject
    private UserAPI userAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getSession().getAttribute("id"));
        int eventId = (Integer) req.getSession().getAttribute("id");
        System.out.println("eventId : " + eventId);

        Event event = eventAPI.getEvent(eventId);

        String name = req.getParameter("name");
        if (!(name == null || name.length() < 1)) eventAPI.updateName(event, name);
        event.setName("eeeeeeeee");
        System.out.println(name);

        String description = req.getParameter("description");
        if (!(description == null || description.length() < 1)) eventAPI.updateDescription(event, description);
        System.out.println(description);

        String image = req.getParameter("image");
        if (!(image == null || image.length() < 1)) eventAPI.updateImageUrl(event, image);
        System.out.println(image);

        String location = req.getParameter("location");
        if (!(location == null || location.length() < 1)) eventAPI.updateLocation(event, location);
        System.out.println(location);

        int categoryId = -1;
        String category = req.getParameter("category");
        if (!(category == null || category.length() < 1)) {
            categoryId = Integer.parseInt(category);
            eventAPI.updateCategory(event, categoryAPI.getCategory(categoryId));
        }
        System.out.println(categoryId);

        String error = "";

        String date = req.getParameter("startdate");
        System.out.println(date);
        if (!(date == null || date.length() < 1)) {

            DateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

            Date startDate = null;
            try {
                startDate = df.parse(date);
                System.out.println("GIVIIIIIIII");
                eventAPI.updateStartDate(event, startDate);
            } catch (ParseException ignored) {}
        }
        System.out.println(date);

        resp.sendRedirect("indexservlet?success=Event successfully edited");
    }
}
