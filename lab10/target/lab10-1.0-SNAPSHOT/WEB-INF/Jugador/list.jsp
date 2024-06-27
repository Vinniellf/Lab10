<%--
  Created by IntelliJ IDEA.
  User: CARLOS
  Date: 24/06/2024
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.example.lab10.entidad.Jugador" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="jugadores" type="java.util.ArrayList<com.example.lab10.entidad.Jugador>" scope="request"/>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../includes/bootstrap_header.jsp"/>
    <title>Lista Jugadores</title>
</head>
<body>
<div class='container'>
    <h1 class='mb-3'>Lista de Jugadores</h1>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="<%= request.getContextPath()%>">Home</a></li>
            <li class="breadcrumb-item active">Jugadores</li>
            <li class="breadcrumb-item"><a href="<%= request.getContextPath()%>/EstadioController">Estadios</a></li>
        </ol>
    </nav>
    <a href="<%= request.getContextPath()%>/JugadorController?action=form" class="btn btn-primary mb-4">
        Agregar nuevo Jugador</a>
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Edad</th>
            <th>Posicion</th>
            <th>Club</th>
            <th>Seleccion</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%
            int i = 1;
            for (Jugador e : jugadores) {
        %>
        <tr>
            <td><%= i%>
            </td>
            <td><%= e.getNombre()%>
            </td>
            <td><%= e.getEdad()%>
            </td>
            <td><%= e.getPosicion()%>
            </td>
            <td><%= e.getClub()%>
            </td>
            <td><%= e.getSeleccion().getNombre()%>
            </td>
            <td>
                <a class="btn btn-primary"
                   href="<%=request.getContextPath()%>/JugadorController?action=borrar&id=<%=e.getIdJugador()%>">
                    <i class="bi bi-trash"></i>
                </a>
            </td>
        </tr>
        <%
                i++;
            }
        %>
        </tbody>
    </table>
</div>
<jsp:include page="../../includes/bootstrap_footer.jsp"/>
</body>
</html>