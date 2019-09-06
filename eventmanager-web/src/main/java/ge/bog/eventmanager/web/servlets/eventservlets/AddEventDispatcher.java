package ge.bog.eventmanager.web.servlets.eventservlets;

import ge.bog.eventmanager.core.CategoryAPI;
import ge.bog.eventmanager.model.Category;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("dispatcher")
public class AddEventDispatcher extends HttpServlet {

    @Inject
    private CategoryAPI categoryAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> list = categoryAPI.getCategories();
        req.setAttribute("categories", list);
        req.getRequestDispatcher("add_event.jsp").forward(req, resp);
    }
}
