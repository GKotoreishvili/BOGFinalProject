package ge.bog.eventmanager.web.servlets.rootservlets;

import ge.bog.eventmanager.core.CategoryAPI;
import ge.bog.eventmanager.core.EventAPI;
import ge.bog.eventmanager.model.Category;
import ge.bog.eventmanager.model.Event;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("indexservlet")
public class IndexServlet extends HttpServlet {

    @Inject
    private EventAPI eventAPI;

    @Inject
    private CategoryAPI categoryAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> list = eventAPI.getEvents();
        req.setAttribute("events", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("index.jsp");
    }
}
