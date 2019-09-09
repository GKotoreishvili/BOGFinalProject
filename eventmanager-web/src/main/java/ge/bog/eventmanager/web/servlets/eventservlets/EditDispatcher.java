package ge.bog.eventmanager.web.servlets.eventservlets;

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

@WebServlet("editdispatcher")
public class EditDispatcher extends HttpServlet {

    @Inject
    private EventAPI eventAPI;

    @Inject
    private CategoryAPI categoryAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Event event = eventAPI.getEvent(Integer.parseInt(id));
        req.setAttribute("event", event);

        List<Category> list = categoryAPI.getCategories();
        req.setAttribute("categories", list);
        req.getRequestDispatcher("edit_event.jsp").forward(req, resp);
    }
}
