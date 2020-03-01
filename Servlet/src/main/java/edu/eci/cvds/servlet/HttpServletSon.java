package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Optional;

import static edu.eci.cvds.servlet.Service.getTodo;

@WebServlet(
        urlPatterns = "/myWebApp"
)
public class HttpServletSon extends HttpServlet {
    private ArrayList<Todo> queryList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = null;
        try {
            responseWriter = resp.getWriter();
            Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
            String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
            int id = Integer.parseInt(name);
            Todo query = getTodo(id);
            queryList.add(query);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setContentType("text/html");
            responseWriter.write(Service.todosToHTMLTable(queryList));
            responseWriter.flush();

        } catch (FileNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.setContentType("text/html");
            responseWriter.write("<h1>No existe un item con el identificador dado.</h1>");
            responseWriter.flush();

        } catch (MalformedURLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        } catch (NumberFormatException | IOException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = null;
        try {
            responseWriter = resp.getWriter();
            Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
            String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
            int id = Integer.parseInt(name);
            Todo query = getTodo(id);
            queryList.add(query);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setContentType("text/html");
            responseWriter.write(Service.todosToHTMLTable(queryList));
            responseWriter.flush();

        } catch (FileNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.setContentType("text/html");
            responseWriter.write("<h1>No existe un item con el identificador dado.</h1>");
            responseWriter.flush();

        } catch (MalformedURLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        } catch (NumberFormatException | IOException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
