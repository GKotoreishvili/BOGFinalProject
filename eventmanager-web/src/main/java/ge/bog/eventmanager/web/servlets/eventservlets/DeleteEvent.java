package ge.bog.eventmanager.web.servlets.eventservlets;

import ge.bog.eventmanager.core.EventAPI;
import ge.bog.eventmanager.model.Event;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("deleteevent")
public class DeleteEvent extends HttpServlet {

    @Inject
    private EventAPI eventAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Event event = eventAPI.getEvent(id);
        eventAPI.deleteEvent(event);
        resp.sendRedirect("indexservlet?success=Event successfully deleted");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
