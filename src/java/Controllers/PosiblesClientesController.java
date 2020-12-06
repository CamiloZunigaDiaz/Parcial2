/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.clsPosiblesClientes;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author camil
 */
@WebServlet(name = "PosiblesClientesController", urlPatterns = {"/PosiblesClientesController"})
public class PosiblesClientesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("btnGuardar") != null) {
            btnGuardar(request, response);
            
        } else if (request.getParameter("btnModificar") != null) {
            btnModificar(request, response);
        } else if (request.getParameter("btnCancelar") != null) {
            
        } else if (request.getParameter("codigoSeleccionado") != null) {
            if (request.getParameter("stOpcion").equals("M")) {
                
                cargarModificar(request, response);
                
            } else if (request.getParameter("stOpcion").equals("E")) {
                btnEliminar(request, response);
            }
            
        }
    }

    public void btnModificar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        
        try {
           
            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();
            
            HttpSession session = request.getSession(true);
            
            if(session.getAttribute("session_lstclsPosiblesClientes") != null){
            
            lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");
            
            }
            
           int inPosicion = 0;
           
            for (clsPosiblesClientes elem : lstclsPosiblesClientes) {
                if(elem.getInCodigo() == Integer.parseInt(request.getParameter("codigoModificar"))){
                
                break;
                
                }
                inPosicion++;
            }
            
            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
            Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
            Models.clsSector obclsSector = new Models.clsSector();
            Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();
            
            if (request.getParameter("txtEmpresa") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStEmpresa(request.getParameter("txtEmpresa"));
                
            }
            if (request.getParameter("txtNombre") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStNombre(request.getParameter("txtNombre"));
                
            }
            if (request.getParameter("txtApellidos") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStApellidos(request.getParameter("txtApellidos"));
                
            }
            if (request.getParameter("txtTitulo") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStTitulo(request.getParameter("txtTitulo"));
                
            }
            if (request.getParameter("txtCorreoElectronico") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStCorreoElectronico(request.getParameter("txtCorreoElectronico"));
                
            }
            if (request.getParameter("txtTelefono") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStTelefono(request.getParameter("txtTelefono"));
                
            }
            if (request.getParameter("txtFax") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStFax(request.getParameter("txtFax"));
                
            }
            if (request.getParameter("txtMovile") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStMovile(request.getParameter("txtMovile"));
                
            }
            if (request.getParameter("txtSitioWed") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStSitioWed(request.getParameter("txtSitioWed"));
                
            }
            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));
                String stDescripcion = "";
                if (request.getParameter("ddlFuentePosibleCliente").equals("1")) {
                    stDescripcion = "None";
                    
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("2")) {
                    
                    stDescripcion = "Aviso";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("3")) {
                    
                    stDescripcion = "Llamada no solicitada";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("4")) {
                    
                    stDescripcion = "Recomendacion empleado";
                    
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("5")) {
                    
                    stDescripcion = "Recomendacion Externa";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("6")) {
                    
                    stDescripcion = "Tienda en linea";
                }
                
                obclsFuentePosibleCliente.setStDescripcion(stDescripcion);
                
                lstclsPosiblesClientes.get(inPosicion).setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }
            if (request.getParameter("ddlEstadoPosibleCliente") != null) {
                obclsEstadoPosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlEstadoPosibleCliente")));
                String stDescripcion = "";
                if (request.getParameter("ddlEstadoPosibleCliente").equals("1")) {
                    stDescripcion = "None";
                    
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("2")) {
                    
                    stDescripcion = "Intento de Contacto";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("3")) {
                    
                    stDescripcion = "Contactar en el Futuro";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("4")) {
                    
                    stDescripcion = "Contactado";
                    
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("5")) {
                    
                    stDescripcion = "Posiblecliente no solicitado";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("6")) {
                    
                    stDescripcion = "Posible cliente perdido";
                }
                obclsEstadoPosibleCliente.setStDescripcion(stDescripcion);
                
                lstclsPosiblesClientes.get(inPosicion).setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);
            }
            if (request.getParameter("ddlSector") != null) {
                obclsSector.setInCodigo(Integer.parseInt(request.getParameter("ddlSector")));
                String stDescripcion = "";
                
                if (request.getParameter("ddlSector").equals("1")) {
                    stDescripcion = "None";
                    
                } else if (request.getParameter("ddlSector").equals("2")) {
                    
                    stDescripcion = "APS (Proveedor de aplicaciones";
                } else if (request.getParameter("ddlSector").equals("3")) {
                    
                    stDescripcion = "OEM de datos";
                } else if (request.getParameter("ddlSector").equals("4")) {
                    
                    stDescripcion = "ERP (Planificacion de de recursos de empresa)";
                    
                } else if (request.getParameter("ddlSector").equals("5")) {
                    
                    stDescripcion = "Gobierno/Ejercito";
                } else if (request.getParameter("ddlSector").equals("6")) {
                    
                    stDescripcion = "Empresa Grande";
                }
                obclsSector.setStDescripcion(stDescripcion);
                
                lstclsPosiblesClientes.get(inPosicion).setObclsSector(obclsSector);
            }
            
            if (request.getParameter("txtCantidadEmpleados") != null) {
                
                lstclsPosiblesClientes.get(inPosicion).setInCantidadEmpleados(Integer.parseInt(request.getParameter("txtCantidadEmpleados")));
            }
            if (request.getParameter("txtIngresosAnuales") != null) {
                
                lstclsPosiblesClientes.get(inPosicion).setDbIngresosAnuales(Double.parseDouble(request.getParameter("txtIngresosAnuales")));
            }
            if (request.getParameter("ddlCalificacion") != null) {
                obclsCalificacion.setInCodigo(Integer.parseInt(request.getParameter("ddlCalificacion")));
                String stDescripcion = "";
                
                if (request.getParameter("ddlCalificacion").equals("1")) {
                    stDescripcion = "None";
                    
                } else if (request.getParameter("ddlCalificacion").equals("2")) {
                    
                    stDescripcion = "Adquirido";
                } else if (request.getParameter("ddlCalificacion").equals("3")) {
                    
                    stDescripcion = "Activo";
                } else if (request.getParameter("ddlCalificacion").equals("4")) {
                    
                    stDescripcion = "Fallo de Mercado";
                    
                } else if (request.getParameter("ddlCalificacion").equals("5")) {
                    
                    stDescripcion = "Proyecto Cancelado";
                } else if (request.getParameter("ddlCalificacion").equals("6")) {
                    
                    stDescripcion = "Apagar";
                }
                obclsCalificacion.setStDescripcion(stDescripcion);
                
                lstclsPosiblesClientes.get(inPosicion).setObclsCalificacion(obclsCalificacion);
            }
            if (request.getParameter("chNoParticipacionCorreoElectronico") != null) {
                
                char chSeleccion = request.getParameter("chNoParticipacionCorreoElectronico").equals("on")
                        ? 'S' : 'N';
                lstclsPosiblesClientes.get(inPosicion).setChNoParticipacionCorreoElectronico(chSeleccion);
            } else {
                lstclsPosiblesClientes.get(inPosicion).setChNoParticipacionCorreoElectronico('N');
            }
            
            if (request.getParameter("txtIDSkype") != null) {
                
                lstclsPosiblesClientes.get(inPosicion).setStIDSkype(request.getParameter("txtIDSkype"));
            }
            if (request.getParameter("txtTwitter") != null) {
                
                lstclsPosiblesClientes.get(inPosicion).setStTwitter(request.getParameter("txtTwitter"));
            }
            if (request.getParameter("txtCorreoSecundario") != null) {
                
                lstclsPosiblesClientes.get(inPosicion).setStCorreoSecundario(request.getParameter("txtCorreoSecundario"));
            }
            
            session.setAttribute("session_lstclsPosiblesClientes", lstclsPosiblesClientes);
            
            request.setAttribute("stMensaje", "Se realizo proceso con exito");
            request.setAttribute("stTipo", "success");
            
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
                
            
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
            
        }
    }

    public void btnEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();
            
            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();
            
            HttpSession session = request.getSession(true);
            
            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");
                
            }
            
            for (Models.clsPosiblesClientes item : lstclsPosiblesClientes) {
                
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    
                    obclsPosiblesClientes = item;
                    
                    lstclsPosiblesClientes.remove(item);
                    
                    break;
                    
                }
                
            }
            session.setAttribute("session_lstclsPosiblesClientes", lstclsPosiblesClientes);
            request.setAttribute("stTipo", "success");
            request.setAttribute("stMensaje", "se realizo proceso con exito.");
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }
    
    public void cargarModificar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        
        try {
            
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();
            
            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();
            
            HttpSession session = request.getSession(true);
            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");
            }
            for (Models.clsPosiblesClientes item : lstclsPosiblesClientes) {
                
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    
                    obclsPosiblesClientes = item;
                    
                }
                
            }
            
            request.setAttribute("obclsPosiblesClientes", obclsPosiblesClientes);
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
            
        } catch (Exception ex) {
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }
    
    public void btnGuardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            
            Models.clsPosiblesClientes obclsPosiblesCLientes = new Models.clsPosiblesClientes();
            
            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
            Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
            Models.clsSector obclsSector = new Models.clsSector();
            Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();
            
            if (request.getParameter("txtEmpresa") != null) {
                obclsPosiblesCLientes.setStEmpresa(request.getParameter("txtEmpresa"));
                
            }
            if (request.getParameter("txtNombre") != null) {
                obclsPosiblesCLientes.setStNombre(request.getParameter("txtNombre"));
                
            }
            if (request.getParameter("txtApellidos") != null) {
                obclsPosiblesCLientes.setStApellidos(request.getParameter("txtApellidos"));
                
            }
            if (request.getParameter("txtTitulo") != null) {
                obclsPosiblesCLientes.setStTitulo(request.getParameter("txtTitulo"));
                
            }
            if (request.getParameter("txtCorreoElectronico") != null) {
                obclsPosiblesCLientes.setStCorreoElectronico(request.getParameter("txtCorreoElectronico"));
                
            }
            if (request.getParameter("txtTelefono") != null) {
                obclsPosiblesCLientes.setStTelefono(request.getParameter("txtTelefono"));
                
            }
            if (request.getParameter("txtFax") != null) {
                obclsPosiblesCLientes.setStFax(request.getParameter("txtFax"));
                
            }
            if (request.getParameter("txtMovile") != null) {
                obclsPosiblesCLientes.setStMovile(request.getParameter("txtMovile"));
                
            }
            if (request.getParameter("txtSitioWed") != null) {
                obclsPosiblesCLientes.setStSitioWed(request.getParameter("txtSitioWed"));
                
            }
            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));
                String stDescripcion = "";
                if (request.getParameter("ddlFuentePosibleCliente").equals("1")) {
                    stDescripcion = "None";
                    
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("2")) {
                    
                    stDescripcion = "Aviso";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("3")) {
                    
                    stDescripcion = "Llamada no solicitada";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("4")) {
                    
                    stDescripcion = "Recomendacion empleado";
                    
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("5")) {
                    
                    stDescripcion = "Recomendacion Externa";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("6")) {
                    
                    stDescripcion = "Tienda en linea";
                }
                
                obclsFuentePosibleCliente.setStDescripcion(stDescripcion);
                
                obclsPosiblesCLientes.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }
            if (request.getParameter("ddlEstadoPosibleCliente") != null) {
                obclsEstadoPosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlEstadoPosibleCliente")));
                String stDescripcion = "";
                if (request.getParameter("ddlEstadoPosibleCliente").equals("1")) {
                    stDescripcion = "None";
                    
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("2")) {
                    
                    stDescripcion = "Intento de Contacto";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("3")) {
                    
                    stDescripcion = "Contactar en el Futuro";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("4")) {
                    
                    stDescripcion = "Contactado";
                    
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("5")) {
                    
                    stDescripcion = "Posiblecliente no solicitado";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("6")) {
                    
                    stDescripcion = "Posible cliente perdido";
                }
                obclsEstadoPosibleCliente.setStDescripcion(stDescripcion);
                
                obclsPosiblesCLientes.setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);
            }
            if (request.getParameter("ddlSector") != null) {
                obclsSector.setInCodigo(Integer.parseInt(request.getParameter("ddlSector")));
                String stDescripcion = "";
                
                if (request.getParameter("ddlSector").equals("1")) {
                    stDescripcion = "None";
                    
                } else if (request.getParameter("ddlSector").equals("2")) {
                    
                    stDescripcion = "APS (Proveedor de aplicaciones";
                } else if (request.getParameter("ddlSector").equals("3")) {
                    
                    stDescripcion = "OEM de datos";
                } else if (request.getParameter("ddlSector").equals("4")) {
                    
                    stDescripcion = "ERP (Planificacion de de recursos de empresa)";
                    
                } else if (request.getParameter("ddlSector").equals("5")) {
                    
                    stDescripcion = "Gobierno/Ejercito";
                } else if (request.getParameter("ddlSector").equals("6")) {
                    
                    stDescripcion = "Empresa Grande";
                }
                obclsSector.setStDescripcion(stDescripcion);
                
                obclsPosiblesCLientes.setObclsSector(obclsSector);
            }
            
            if (request.getParameter("txtCantidadEmpleados") != null) {
                
                obclsPosiblesCLientes.setInCantidadEmpleados(Integer.parseInt(request.getParameter("txtCantidadEmpleados")));
            }
            if (request.getParameter("txtIngresosAnuales") != null) {
                
                obclsPosiblesCLientes.setDbIngresosAnuales(Double.parseDouble(request.getParameter("txtIngresosAnuales")));
            }
            if (request.getParameter("ddlCalificacion") != null) {
                obclsCalificacion.setInCodigo(Integer.parseInt(request.getParameter("ddlCalificacion")));
                String stDescripcion = "";
                
                if (request.getParameter("ddlCalificacion").equals("1")) {
                    stDescripcion = "None";
                    
                } else if (request.getParameter("ddlCalificacion").equals("2")) {
                    
                    stDescripcion = "Adquirido";
                } else if (request.getParameter("ddlCalificacion").equals("3")) {
                    
                    stDescripcion = "Activo";
                } else if (request.getParameter("ddlCalificacion").equals("4")) {
                    
                    stDescripcion = "Fallo de Mercado";
                    
                } else if (request.getParameter("ddlCalificacion").equals("5")) {
                    
                    stDescripcion = "Proyecto Cancelado";
                } else if (request.getParameter("ddlCalificacion").equals("6")) {
                    
                    stDescripcion = "Apagar";
                }
                obclsCalificacion.setStDescripcion(stDescripcion);
                
                obclsPosiblesCLientes.setObclsCalificacion(obclsCalificacion);
            }
            if (request.getParameter("chNoParticipacionCorreoElectronico") != null) {
                
                char chSeleccion = request.getParameter("chNoParticipacionCorreoElectronico").equals("on")
                        ? 'S' : 'N';
                obclsPosiblesCLientes.setChNoParticipacionCorreoElectronico(chSeleccion);
            } else {
                obclsPosiblesCLientes.setChNoParticipacionCorreoElectronico('N');
            }
            
            if (request.getParameter("txtIDSkype") != null) {
                
                obclsPosiblesCLientes.setStIDSkype(request.getParameter("txtIDSkype"));
            }
            if (request.getParameter("txtTwitter") != null) {
                
                obclsPosiblesCLientes.setStTwitter(request.getParameter("txtTwitter"));
            }
            if (request.getParameter("txtCorreoSecundario") != null) {
                
                obclsPosiblesCLientes.setStCorreoSecundario(request.getParameter("txtCorreoSecundario"));
            }
            
            HttpSession session = request.getSession(true);
            
            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();
            
            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");
            }
            int inCodigo = lstclsPosiblesClientes.size() + 1;
            obclsPosiblesCLientes.setInCodigo(inCodigo);
            
            lstclsPosiblesClientes.add(obclsPosiblesCLientes);
            session.setAttribute("session_lstclsPosiblesClientes", lstclsPosiblesClientes);
            
            request.setAttribute("stMensaje", "Se realizo proceso con exito");
            request.setAttribute("stTipo", "success");
            
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
