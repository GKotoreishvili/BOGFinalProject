package ge.bog.eventmanager.web.servlets.userservlets;

import ge.bog.eventmanager.core.UserAPI;
import ge.bog.eventmanager.model.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("login")
public class LogIn extends HttpServlet {

    @Inject
    private UserAPI userAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errors = "";

        String userName = req.getParameter("username");
        if (userName.length() <= 0) errors += "<p class='error'>You must enter user name</p>";

        if (!userAPI.checkUserName(userName)) {
            errors += "<p class='error'>User name doesn't exist</p>";
        }

        String password = req.getParameter("password");
        if (password.length() < 6) errors += "<p class='error'>password must contain at least 6 symbols</p>";

        if (errors.length() > 0) {
            req.setAttribute("error", errors);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        if (!userAPI.checkLogin(userName, password)) {
            errors += "<p class='error'>Password doesn't match</p>";
        }

        if (errors.length() > 0) {
            req.setAttribute("error", errors);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        resp.sendRedirect("indexservlet");
    }
}
