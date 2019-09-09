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

@WebServlet("deletecategory")
public class DeleteCategory extends HttpServlet {

    @Inject
    private CategoryAPI categoryAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errors = "";

        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryAPI.getCategory(id);
        if (categoryAPI.checkIfInUse(category)) errors += "<p class='error'>You can't delete category when it's in use</p>";

        if (errors.length() > 0) {
            resp.sendRedirect("indexservlet");
            return;
        }

        categoryAPI.deleteCategory(categoryAPI.getCategory(id));
        resp.sendRedirect("allcategories");
    }
}
