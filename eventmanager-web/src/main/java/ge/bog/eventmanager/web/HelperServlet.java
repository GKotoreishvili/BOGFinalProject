package ge.bog.eventmanager.web;

import ge.bog.eventmanager.core.EventAPI;
import ge.bog.eventmanager.model.Event;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("helper")
public class HelperServlet extends HttpServlet {

    @Inject
    private EventAPI eventAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> list = eventAPI.getEvents();
        req.setAttribute("events", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
