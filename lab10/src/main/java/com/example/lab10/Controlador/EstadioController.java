package com.example.lab10.Controlador;

import com.example.lab10.entidad.Estadio;
import com.example.lab10.repositorio.EstadioRepository;
import com.example.lab10.repositorio.SeleccionRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EstadioController", urlPatterns = {"/EstadioController"})
public class EstadioController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null? "listar" : request.getParameter("action");
        SeleccionRepository sr = new SeleccionRepository();
        EstadioRepository er = new EstadioRepository();

        switch (action) {
            case "listar":
                request.setAttribute("estadios", er.listarEstadios());
                request.getRequestDispatcher("WEB-INF/Estadio/list.jsp").forward(request, response);
                break;

            case "form":
                request.getRequestDispatcher("WEB-INF/Estadio/newForm.jsp").forward(request, response);
                break;

            case "borrar":
                int id =  Integer.parseInt(request.getParameter("id"));
                er.eliminarEstadio(id);
                response.sendRedirect("EstadioController");
                break;

        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EstadioRepository er = new EstadioRepository();
        String action = request.getParameter("action");

        switch (action) {

            case "agregar":
                Estadio e = new Estadio();

                e.setNombre(request.getParameter("nombre"));
                e.setProvincia(request.getParameter("provincia"));
                e.setClub(request.getParameter("club"));

                er.insertarEstadio(e);
                response.sendRedirect("EstadioController");
                break;
        }
    }
}
