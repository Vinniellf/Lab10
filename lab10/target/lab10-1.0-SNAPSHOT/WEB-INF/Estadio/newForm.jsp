<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../includes/bootstrap_header.jsp"/>
    <title>Nuevo Estadio</title>
</head>
<body>
<div class='container'>
    <div class="row justify-content-center">
        <form method="POST" action="EstadioController?action=agregar" class="col-md-6 col-lg-6">
            <h1 class='mb-3'>Nuevo Estadio</h1>
            <hr>
            <div class="mb-3">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control form-control-sm" name="nombre" id="nombre">
            </div>
            <div class="mb-3">
                <label for="provincia">Provincia</label>
                <input type="text" class="form-control form-control-sm" name="provincia" id="provincia">
            </div>
            <div class="mb-3">
                <label for="club">Club</label>
                <input type="text" class="form-control form-control-sm" name="club" id="club">
            </div>


            <a href="<%= request.getContextPath()%>/EstadioController" class="btn btn-danger">Cancelar</a>
            <input type="submit" value="Guardar" class="btn btn-primary"/>
        </form>
    </div>
</div>
<jsp:include page="../../includes/bootstrap_footer.jsp"/>
</body>
</html>