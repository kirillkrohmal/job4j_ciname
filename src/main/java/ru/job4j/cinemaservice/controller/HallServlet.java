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

@WebServlet("/myForm")
public class HallServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();
    Halls halls = new Halls();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("halls", this.logic.values());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/cinemaservice/cinemaindex.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

       /* if (halls.getRows() == null || halls.getColumns() == null) {
            logic.addHalls(req.getParameter("rows"), req.getParameter("columns"));
        } else {
            logic.addHalls(req.getParameter("rows"), req.getParameter("columns"));
        } */


        String rows = req.getParameter("rows");
        String columns = req.getParameter("columns");

        resp.setContentType("text/html");
        PrintWriter pw=resp.getWriter();
        pw.write("<h2> Following data received sucessfully.. <h2> <br>");
        pw.write("<h3> Email: "+ rows +" </h3>");
        pw.write("<h3> User name: "+ columns +" </h3>");

        pw.write("</h3>");

        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/payment"));
    }
}