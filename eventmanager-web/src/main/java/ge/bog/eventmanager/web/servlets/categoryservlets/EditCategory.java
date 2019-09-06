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

@WebServlet("editcategory")
public class EditCategory extends HttpServlet {

    @Inject
    private CategoryAPI categoryAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryAPI.getCategory(id);
        req.setAttribute("category", category);
        req.getRequestDispatcher("edit_category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errors = "";
        int id = (Integer) req.getSession().getAttribute("id");

        String name = req.getParameter("name");
        if (name.length() < 1) errors += "<p class='error'>Enter category name</p>";

        if (categoryAPI.findCategory(name)) errors += "<p class='error'>Category already exists</p>";

        System.out.println(errors);
        if (errors.length() > 0) {
            req.setAttribute("error", errors);
            req.getRequestDispatcher("edit_category.jsp").forward(req, resp);
            return;
        }

        Category category = categoryAPI.getCategory(id);
        category.setName(name);
        categoryAPI.updateCategory(category, name.toUpperCase());
        resp.sendRedirect("allcategories");
    }
}
