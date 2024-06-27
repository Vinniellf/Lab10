<%--
  Created by IntelliJ IDEA.
  User: CARLOS
  Date: 24/06/2024
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.example.lab10.entidad.Estadio" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="estadios" type="java.util.ArrayList<com.example.lab10.entidad.Estadio>" scope="request"/>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../includes/bootstrap_header.jsp"/>
    <title>Lista Estadios</title>
</head>
<body>
<div class='container'>
    <h1 class='mb-3'>Lista de Estadios</h1>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="<%= request.getContextPath()%>">Home</a></li>
            <li class="breadcrumb-item"><a href="<%= request.getContextPath()%>/JugadorController">Jugadores</a></li>
            <li class="breadcrumb-item active">Estadios</li>
        </ol>
    </nav>
    <a href="<%= request.getContextPath()%>/EstadioController?action=form" class="btn btn-primary mb-4">
        Agregar nuevo Estadio</a>
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Provincia</th>
            <th>Club</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%
            int i = 1;
            for (Estadio e : estadios) {
        %>
        <tr>
            <td><%= i%>
            </td>
            <td><%= e.getNombre()%>
            </td>
            <td><%= e.getProvincia()%>
            </td>
            <td><%= e.getClub()%>
            </td>
            <td>
                <a class="btn btn-primary"
                   href="<%=request.getContextPath()%>/EstadioController?action=borrar&id=<%=e.getIdEstadio()%>">
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