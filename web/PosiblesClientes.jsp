<%-- 
    Document   : PosiblesClientes
    Created on : 2/12/2020, 05:27:52 PM
    Author     : camil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Posibles Clientes</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <link href="css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>

    </head>
    <body>
        <%
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();

            if (request.getAttribute("obclsPosiblesClientes") != null) {

                obclsPosiblesClientes = (Models.clsPosiblesClientes) request.getAttribute("obclsPosiblesClientes");
            }

            List<Models.clsPosiblesClientes> lstclsPosiblesClientes
                    = new ArrayList<Models.clsPosiblesClientes>();

            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");
            }
            if (request.getAttribute("stMensaje") != null
                    && request.getAttribute("stTipo") != null) {

        %>
        <input type="text" hidden="" id="txtMensaje" value="<%=request.getAttribute("stMensaje")%>"/>
        <input type="text" hidden="" id="txtTipo" value="<%=request.getAttribute("stTipo")%>"/>
        <script>
            var mensaje = document.getElementById("txtMensaje").value;
            var tipo = document.getElementById("txtTipo").value;

            swal("mensaje", mensaje, tipo);
        </script>
        <%
            }
        %>  

        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">Crear Posibles Clientes</div>
                <div class="card-body">
                    <form action="PosiblesClientesController" method="post">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <input type="submit" value="Guardar" class="btn btn-primary" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-primary" name="btnModificar"/>
                                    <input type="submit" value="Cancelar" class="btn btn-primary" name="btnCancelar"/>
                                    <a class="btn btn-primary" href="Index.jsp">Volver</a>
                                    <input type="text" name="codigoModificar" id="codigoModificar" value="<%= obclsPosiblesClientes.getInCodigo()%>" hidden="">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <h1>Informacion de Posible cliente</h1>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label name="lblEmpresa">Empresa</label>
                                    <input type="text" placeholder="Ingrese Empresa" name="txtEmpresa" class="form-control" 
                                           value="<%= obclsPosiblesClientes.getStEmpresa() != null ? obclsPosiblesClientes.getStEmpresa() : ""%>" />
                                </div>
                                <div class="col-md-3">
                                    <label name="lblNombre">Nombre</label>
                                    <input type="text" placeholder="Ingrese Nombre" name="txtNombre" class="form-control"
                                           value="<%= obclsPosiblesClientes.getStNombre() != null ? obclsPosiblesClientes.getStNombre() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblApellidos">Apellidos</label>
                                    <input type="text" placeholder="Ingrese Apellidos" name="txtApellidos" class="form-control" 
                                           value="<%= obclsPosiblesClientes.getStApellidos() != null ? obclsPosiblesClientes.getStApellidos() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblTitulo">Titulo</label>
                                    <input type="text" placeholder="Ingrese Titulo" name="txtTitulo" class="form-control"
                                           value="<%= obclsPosiblesClientes.getStTitulo() != null ? obclsPosiblesClientes.getStTitulo() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label name="lblCorreoElectronico">Correo Electronico</label>
                                    <input type="email" placeholder="Ingrese Correo" name="txtCorreoElectronico" class="form-control"
                                           value="<%= obclsPosiblesClientes.getStCorreoElectronico() != null ? obclsPosiblesClientes.getStCorreoElectronico() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblTelefono">Telefono</label>
                                    <input type="text" placeholder="Ingrese Telefono" name="txtTelefono" class="form-control"
                                           value="<%= obclsPosiblesClientes.getStTelefono() != null ? obclsPosiblesClientes.getStTelefono() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblFax">Fax</label>
                                    <input type="text" placeholder="Ingrese Fax" name="txtFax" class="form-control"
                                           value="<%= obclsPosiblesClientes.getStFax() != null ? obclsPosiblesClientes.getStFax() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblMovile">Movile</label>
                                    <input type="text" placeholder="Ingrese Movile" name="txtMovile" class="form-control"
                                           value="<%= obclsPosiblesClientes.getStMovile() != null ? obclsPosiblesClientes.getStMovile() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label name="lblSitioWed">Sitio wed</label>
                                    <input type="text" placeholder="Ingrese Sitio Wed" name="txtSitioWed" class="form-control"
                                           value="<%= obclsPosiblesClientes.getStSitioWed() != null ? obclsPosiblesClientes.getStSitioWed() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblFuentePosibleCliente">Fuente de Posible Cliente</label>
                                    <select class="form-control" name="ddlFuentePosibleCliente">
                                        <option value="1" <%= obclsPosiblesClientes.obclsFuentePosibleCliente != null ? obclsPosiblesClientes.obclsFuentePosibleCliente.getInCodigo() == 1 ? "selected" : "" : ""%>>None</option>
                                        <option value="2" <%= obclsPosiblesClientes.obclsFuentePosibleCliente != null ? obclsPosiblesClientes.obclsFuentePosibleCliente.getInCodigo() == 2 ? "selected" : "" : ""%>>Aviso</option>
                                        <option value="3" <%= obclsPosiblesClientes.obclsFuentePosibleCliente != null ? obclsPosiblesClientes.obclsFuentePosibleCliente.getInCodigo() == 3 ? "selected" : "" : ""%>>Llamada no solicitada</option>
                                        <option value="4" <%= obclsPosiblesClientes.obclsFuentePosibleCliente != null ? obclsPosiblesClientes.obclsFuentePosibleCliente.getInCodigo() == 4 ? "selected" : "" : ""%>>Recomendacion de empleado</option>
                                        <option value="5" <%= obclsPosiblesClientes.obclsFuentePosibleCliente != null ? obclsPosiblesClientes.obclsFuentePosibleCliente.getInCodigo() == 5 ? "selected" : "" : ""%>>Recomendacion externa</option>
                                        <option value="6" <%= obclsPosiblesClientes.obclsFuentePosibleCliente != null ? obclsPosiblesClientes.obclsFuentePosibleCliente.getInCodigo() == 6 ? "selected" : "" : ""%>>Tienda en linea</option>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblEstadoPosibleCliente">Estado de Posible Cliente</label>
                                    <select class="form-control" name="ddlEstadoPosibleCliente">
                                        <option value="1" <%= obclsPosiblesClientes.obclsEstadoPosibleCliente != null ? obclsPosiblesClientes.obclsEstadoPosibleCliente.getInCodigo() == 1 ? "selected" : "" : ""%>>None</option>
                                        <option value="2" <%= obclsPosiblesClientes.obclsEstadoPosibleCliente != null ? obclsPosiblesClientes.obclsEstadoPosibleCliente.getInCodigo() == 2 ? "selected" : "" : ""%>>Intento de contacto</option>
                                        <option value="3" <%= obclsPosiblesClientes.obclsEstadoPosibleCliente != null ? obclsPosiblesClientes.obclsEstadoPosibleCliente.getInCodigo() == 3 ? "selected" : "" : ""%>>Contactar en el futuro</option>
                                        <option value="4" <%= obclsPosiblesClientes.obclsEstadoPosibleCliente != null ? obclsPosiblesClientes.obclsEstadoPosibleCliente.getInCodigo() == 4 ? "selected" : "" : ""%>>Contactado</option>
                                        <option value="5" <%= obclsPosiblesClientes.obclsEstadoPosibleCliente != null ? obclsPosiblesClientes.obclsEstadoPosibleCliente.getInCodigo() == 5 ? "selected" : "" : ""%>>Posible cliente no solicitido</option>
                                        <option value="6" <%= obclsPosiblesClientes.obclsEstadoPosibleCliente != null ? obclsPosiblesClientes.obclsEstadoPosibleCliente.getInCodigo() == 6 ? "selected" : "" : ""%>>Posible cliente perdido</option>
                                    </select> 
                                </div>
                                <div class="col-md-3">
                                    <label name="lblSector">Sector</label>
                                    <select class="form-control" name="ddlSector">
                                        <option value="1" <%= obclsPosiblesClientes.obclsSector != null ? obclsPosiblesClientes.obclsSector.getInCodigo() == 1 ? "selected" : "" : ""%>>None</option>
                                        <option value="2" <%= obclsPosiblesClientes.obclsSector != null ? obclsPosiblesClientes.obclsSector.getInCodigo() == 2 ? "selected" : "" : ""%>>APS (Proveedor de servicios de aplicaciones)</option>
                                        <option value="3" <%= obclsPosiblesClientes.obclsSector != null ? obclsPosiblesClientes.obclsSector.getInCodigo() == 3 ? "selected" : "" : ""%>>OEM de datos</option>
                                        <option value="4" <%= obclsPosiblesClientes.obclsSector != null ? obclsPosiblesClientes.obclsSector.getInCodigo() == 4 ? "selected" : "" : ""%>>ERP (Planificacion de recursos de empresa)</option>
                                        <option value="5" <%= obclsPosiblesClientes.obclsSector != null ? obclsPosiblesClientes.obclsSector.getInCodigo() == 5 ? "selected" : "" : ""%>>Gobierno/Ejercito</option>
                                        <option value="6" <%= obclsPosiblesClientes.obclsSector != null ? obclsPosiblesClientes.obclsSector.getInCodigo() == 6 ? "selected" : "" : ""%>>Empresa grande</option>
                                    </select> 
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label name="txtCantidadEmpleados">Cantidad de Empleados</label>
                                    <input type="number" placeholder="Ingrese Cantidad de empleados" name="txtCantidadEmpleados" class="form-control"
                                           value="<%= obclsPosiblesClientes.getInCantidadEmpleados() != 0 ? obclsPosiblesClientes.getInCantidadEmpleados() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblIngresosAnuales">Ingresos Anuales</label>
                                    <input type="text" placeholder="Ingresos Anuales" name="txtIngresosAnuales" class="form-control"
                                           value="<%= obclsPosiblesClientes.getDbIngresosAnuales() != 0 ? obclsPosiblesClientes.getDbIngresosAnuales() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblCalificacion">Calificacion</label>
                                    <select class="form-control" name="ddlCalificacion">
                                        <option value="1"  <%= obclsPosiblesClientes.obclsCalificacion != null ? obclsPosiblesClientes.obclsCalificacion.getInCodigo() == 1 ? "selected" : "" : ""%>>None</option>
                                        <option value="2"  <%= obclsPosiblesClientes.obclsCalificacion != null ? obclsPosiblesClientes.obclsCalificacion.getInCodigo() == 2 ? "selected" : "" : ""%>>Adquirido</option>
                                        <option value="3"  <%= obclsPosiblesClientes.obclsCalificacion != null ? obclsPosiblesClientes.obclsCalificacion.getInCodigo() == 3 ? "selected" : "" : ""%>>Activo</option>
                                        <option value="4"  <%= obclsPosiblesClientes.obclsCalificacion != null ? obclsPosiblesClientes.obclsCalificacion.getInCodigo() == 4 ? "selected" : "" : ""%>>Fallo de Mercado</option>
                                        <option value="5"  <%= obclsPosiblesClientes.obclsCalificacion != null ? obclsPosiblesClientes.obclsCalificacion.getInCodigo() == 5 ? "selected" : "" : ""%>>Proyecto Cancelado</option>
                                        <option value="6"  <%= obclsPosiblesClientes.obclsCalificacion != null ? obclsPosiblesClientes.obclsCalificacion.getInCodigo() == 6 ? "selected" : "" : ""%>>Apagar</option>
                                    </select> 
                                </div>
                                <div class="col-md-3">
                                    <label name="lblNoParticipacionCorreoElectronico">

                                        <input type="checkbox"  name="chNoParticipacionCorreoElectronico" <%= obclsPosiblesClientes.getChNoParticipacionCorreoElectronico() == 'S' ? "checked" : ""%>/>
                                        No Participacion Correo 
                                        Electronico

                                    </label>

                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label name="lblIDSkype">ID de Skype</label>
                                    <input type="txt" placeholder="Ingrese ID Skype" name="txtIDSkype" class="form-control"
                                           value="<%= obclsPosiblesClientes.getStIDSkype() != null ? obclsPosiblesClientes.getStIDSkype() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblTwitter">Twitter</label>
                                    <input type="text" placeholder="Ingrese Twitter" name="txtTwitter" class="form-control"
                                           value="<%= obclsPosiblesClientes.getStTwitter() != null ? obclsPosiblesClientes.getStTwitter() : ""%>"/>
                                </div>
                                <div class="col-md-6">
                                    <label name="lblCorreoSecundario">Correo Electronico Secundario</label>
                                    <input type="text" placeholder="Correo Secundario" name="txtCorreoSecundario" class="form-control"
                                           value="<%= obclsPosiblesClientes.getStCorreoSecundario() != null ? obclsPosiblesClientes.getStCorreoSecundario() : ""%>"/>
                                </div>

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <b>
                                        <i class="fa fa-book"></i>
                                        Registros:<%= lstclsPosiblesClientes.size()%>
                                    </b>
                                </div>
                            </div>

                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <table class="table table-bordered table-primary table-responsive">
                                        <tr>
                                            <td>Empresa</td>
                                            <td>Nombre</td>
                                            <td>Apellidos</td>
                                            <td>Tiutlo</td>
                                            <td>Correo Electronico</td>
                                            <td>Telefono</td>
                                            <td>Fax</td>
                                            <td>Movile</td>
                                            <td>Sitio Wed</td>
                                            <td>Fuente Posible cliente</td>
                                            <td>Estado Posible Cliente</td>
                                            <td>Sector</td> 
                                            <td>Cantidad de Empleados</td>
                                            <td>Ingresos Anuales</td>
                                            <td>Caificacion</td>
                                            <td>No Participacion correo electronico</td>
                                            <td>Skype</td> 
                                            <td>Twitter</td>
                                            <td>Correo Electronico Secundario</td>
                                            <td>Opciones</td>


                                        </tr>
                                        <%
                                            for (Models.clsPosiblesClientes item : lstclsPosiblesClientes) {
                                                Models.clsFuentePosibleCliente obclsFuentePosibleCliente = item.getObclsFuentePosibleCliente();
                                                Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = item.getObclsEstadoPosibleCliente();
                                                Models.clsSector obclsSector = item.getObclsSector();
                                                Models.clsCalificacion obclsCalificacion = item.getObclsCalificacion();

                                        %>
                                        <tr>
                                            <td><%= item.getStEmpresa()%></td>
                                            <td><%= item.getStNombre()%></td>
                                            <td><%= item.getStApellidos()%></td>
                                            <td><%= item.getStTitulo()%></td>
                                            <td><%= item.getStCorreoElectronico()%></td>
                                            <td><%= item.getStTelefono()%></td>
                                            <td><%= item.getStFax()%></td>
                                            <td><%= item.getStMovile()%></td>
                                            <td><%= item.getStSitioWed()%></td>
                                            <td><%= obclsFuentePosibleCliente.getStDescripcion()%></td>
                                            <td><%= obclsEstadoPosibleCliente.getStDescripcion()%></td> 
                                            <td><%= obclsSector.getStDescripcion()%></td>
                                            <td><%= item.getInCantidadEmpleados()%></td>
                                            <td><%= item.getDbIngresosAnuales()%></td>
                                            <td><%= obclsCalificacion.getStDescripcion()%></td>
                                            <td><%= item.getChNoParticipacionCorreoElectronico()%></td> 
                                            <td><%= item.getStIDSkype()%></td>
                                            <td><%= item.getStTwitter()%></td>
                                            <td><%= item.getStCorreoSecundario()%></td>
                                            <td>
                                                <a class="btn btn-primary btn-sm" href="PosiblesClientesController?stOpcion=M&codigoSeleccionado=<%= item.getInCodigo()%>">
                                                    Modificar</a>
                                                <a class="btn btn-danger btn-sm" href="PosiblesClientesController?stOpcion=E&codigoSeleccionado=<%= item.getInCodigo()%>">
                                                    Eliminar</a>

                                            </td>
                                        </tr>


                                        <%
                                            }
                                        %>
                                    </table>

                                </div>

                            </div>

                        </div>
                    </form>

                </div>

            </div>

        </div>
    </body>
</html>
