package ru.job4j.controller;

import ru.job4j.model.Halls;
import ru.job4j.persistence.JdbcStore;
import ru.job4j.service.ValidateService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


public class HallServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("halls", this.logic.values());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/index.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        logic.addHalls(req.getParameter("rows"), req.getParameter("place"));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/payment"));
    }
}