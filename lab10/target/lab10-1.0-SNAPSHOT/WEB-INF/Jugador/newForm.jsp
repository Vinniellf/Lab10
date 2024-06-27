<%@page import="java.util.ArrayList" %>
<%@page import="com.example.lab10.entidad.Seleccion" %>
<%@page import="com.example.lab10.entidad.Jugador" %>
<jsp:useBean id="selecciones" type="java.util.ArrayList<com.example.lab10.entidad.Seleccion>" scope="request" />
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../includes/bootstrap_header.jsp"/>
    <title>Nuevo empleado</title>
</head>
<body>
<div class='container'>
    <div class="row justify-content-center">
        <form method="POST" action="JugadorController?action=agregar" class="col-md-6 col-lg-6">
            <h1 class='mb-3'>Nuevo jugador</h1>
            <hr>
            <div class="mb-3">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control form-control-sm" name="nombre" id="nombre">
            </div>
            <div class="mb-3">
                <label for="edad">Edad</label>
                <input type="text" class="form-control form-control-sm" name="edad" id="edad">
            </div>
            <div class="mb-3">
                <label for="posicion">Posicion</label>
                <input type="text" class="form-control form-control-sm" name="posicion" id="posicion">
            </div>
            <div class="mb-3">
                <label for="club">Club</label>
                <input type="text" class="form-control form-control-sm" name="club" id="club">
            </div>
            <div class="mb-3">
                <label for="seleccion">Seleccion</label>
                <select name="seleccion" class="form-select" id="seleccion">
                    <% for(Seleccion s: selecciones){ %>
                    <option value="<%=s.getIdSeleccion()%>"> <%=s.getNombre()%> </option>
                    <% } %>
                </select>
            </div>


            <a href="<%= request.getContextPath()%>/JugadorController" class="btn btn-danger">Cancelar</a>
            <input type="submit" value="Guardar" class="btn btn-primary"/>
        </form>
    </div>
</div>
<jsp:include page="../../includes/bootstrap_footer.jsp"/>
</body>
</html>