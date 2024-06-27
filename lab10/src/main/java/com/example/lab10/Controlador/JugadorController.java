package com.example.lab10.Controlador;

import com.example.lab10.entidad.Jugador;
import com.example.lab10.entidad.Seleccion;
import com.example.lab10.repositorio.JugadorRepository;
import com.example.lab10.repositorio.SeleccionRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "JugadorController", urlPatterns = {"/JugadorController"})
public class JugadorController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null? "listar" : request.getParameter("action");
        JugadorRepository jr = new JugadorRepository();
        SeleccionRepository sr = new SeleccionRepository();

        switch (action) {
            case "listar":
                request.setAttribute("jugadores", jr.listarJugadores());
                request.getRequestDispatcher("WEB-INF/Jugador/list.jsp").forward(request, response);
                break;

            case "form":
                request.setAttribute("selecciones", sr.obtenerSelecciones());
                request.getRequestDispatcher("WEB-INF/Jugador/newForm.jsp").forward(request, response);
                break;

            case "borrar":
                int id =  Integer.parseInt(request.getParameter("id"));
                jr.eliminarJugador(id);
                response.sendRedirect("JugadorController");
                break;

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JugadorRepository jr = new JugadorRepository();
        String action = request.getParameter("action");

        switch (action){

            case "agregar":
                Jugador j = new Jugador();
                Seleccion s = new Seleccion();

                j.setNombre(request.getParameter("nombre"));
                j.setEdad(Integer.parseInt(request.getParameter("edad")));
                j.setPosicion(request.getParameter("posicion"));
                j.setClub(request.getParameter("club"));
                s.setIdSeleccion(Integer.parseInt(request.getParameter("seleccion")));
                j.setSeleccion(s);
                jr.insertarJugador(j);
                response.sendRedirect("JugadorController");
                break;

        }

    }
}
