package ge.bog.eventmanager.web.servlets.categoryservlets;

import ge.bog.eventmanager.core.CategoryAPI;
import ge.bog.eventmanager.model.Category;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("addcategory")
public class AddCategory extends HttpServlet {

    @Inject
    private CategoryAPI categoryAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errors = "";

        String name = req.getParameter("name");
        if (name.length() < 1) errors += "<p class='error'>Category name must have at least one </p>";

        if (categoryAPI.findCategory(name)) errors += "<p class='error'>Category already exists</p>";

        if (errors.length() > 0) {
            req.setAttribute("error", errors);
            req.getRequestDispatcher("add_category.jsp").forward(req, resp);
            return;
        }

        categoryAPI.addCategory(new Category(name.toUpperCase()));
        resp.sendRedirect("allcategories");
    }
}
