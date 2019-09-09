package ge.bog.eventmanager.web.servlets.userservlets;

import ge.bog.eventmanager.core.EventAPI;
import ge.bog.eventmanager.core.UserAPI;
import ge.bog.eventmanager.model.Event;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("profile")
public class Profile extends HttpServlet {

    @Inject
    private EventAPI eventAPI;

    @Inject
    private UserAPI userAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> list = eventAPI.getUserEvents(userAPI.getUser(1));
        req.setAttribute("userevents", list);
        System.out.println("eeeeeeeeee");
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
        System.out.println("oooooooooo");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
