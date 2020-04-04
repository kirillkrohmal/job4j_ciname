package ru.job4j.cinemaservice.controller;


import ru.job4j.cinemaservice.model.Halls;
import ru.job4j.cinemaservice.service.ValidateService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HallServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/cinemaservice/cinemaindex.jsp");
        req.setAttribute("halls", this.logic.values());
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ValidateService.getInstance().addHalls(req.getParameter("rows"), req.getParameter( "columns"));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/view"));
    }
}