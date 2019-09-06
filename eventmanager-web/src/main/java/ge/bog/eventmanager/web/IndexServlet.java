package ge.bog.eventmanager.web;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("indexservlet")
public class IndexServlet extends HttpServlet {

    @Inject
    private EventAPI eventAPI;

    @Inject
    private CategoryAPI categoryAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}