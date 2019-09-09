package ge.bog.eventmanager.web.servlets.userservlets;

import ge.bog.eventmanager.core.CategoryAPI;
import ge.bog.eventmanager.core.UserAPI;
import ge.bog.eventmanager.model.Category;
import ge.bog.eventmanager.model.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("register")
public class Register extends HttpServlet {

    @Inject
    private UserAPI userAPI;

    @Inject
    private CategoryAPI categoryAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errors = "";

        String firstName = req.getParameter("name");
        if (firstName.length() < 1) errors += "<p class='error'>You must enter first name</p>";
        System.out.println(firstName);

        String lastName = req.getParameter("surname");
        if (lastName.length() < 1) errors += "<p class='error'>You must enter last name</p>";
        System.out.println(lastName);

        String phoneNumber = req.getParameter("number");
        if (phoneNumber.length() < 1) errors += "<p class='error'>You must enter phone number</p>";
        System.out.println(phoneNumber);

        String userName = req.getParameter("username");
        if (userName.length() < 1) errors += "<p class='error'>You must enter user name</p>";
        System.out.println(userName);

        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatpassword");
        if (password.length() < 6) errors += "<p class='error'>password must contain at least 6 symbols</p>";
        if (!password.equals(repeatPassword)) errors += "<p class='error'>Passwords do not match</p>";
        System.out.println(password);
        System.out.println(repeatPassword);
        System.out.println(errors);

        if (errors.length() > 0) {
            req.setAttribute("error", errors);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        System.out.println(password);

        if (userAPI.checkUserName(userName)) {
            errors += "<p class='error'>Username already exists</p>";
        }

        if (userAPI.checkPhoneNumber(phoneNumber)) {
            errors += "<p class='error'>Phone number already in use</p>";
        }

        if (errors.length() > 0) {
            req.setAttribute("error", errors);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        System.out.println("so far so good ha?!");
        userAPI.addUser(new User(firstName, lastName, phoneNumber, userName, password));
        System.out.println("not good guess");
        resp.sendRedirect("index.jsp?success=You have successfully created account");
    }
}
