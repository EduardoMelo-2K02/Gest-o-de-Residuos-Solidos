package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import model.DAO;
import model.Entulho;

@WebServlet(urlPatterns = {"/controlador", "/main", "/insert", "/delete", "/select", "/update"})
public class controlador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private DAO dao = new DAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        
        if (action == null || action.equals("/main") || action.equals("/")) {
            listarTodos(request, response);
        } else if (action.equals("/delete")) {
            removerEntulho(request, response);
        } else if (action.equals("/select")) {
            buscarParaEditar(request, response);
        } else {
            listarTodos(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        
        if (action.equals("/insert")) {
            novoEntulho(request, response);
        } else if (action.equals("/update")) {
            editarEntulho(request, response);
        } else {
            doGet(request, response);
        }
    }

    // READ
    protected void listarTodos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Entulho> lista = dao.listarEntulhos();
        request.setAttribute("entulhos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("listarColetas.jsp");
        rd.forward(request, response);
    }

    // CREATE
    protected void novoEntulho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Entulho novo = new Entulho(); 
        novo.setLogradouro(request.getParameter("logradouro"));
        novo.setMaterial(request.getParameter("material"));
        novo.setVolume(request.getParameter("volume"));
        
        dao.inserirEntulho(novo);
        response.sendRedirect("main");
    }

    // DELETE 
    protected void removerEntulho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Entulho entulhoParaDeletar = new Entulho();
        entulhoParaDeletar.setId(id);
        
        dao.deletarEntulho(entulhoParaDeletar);
        response.sendRedirect("main");
    }

    // UPDATE - Parte 1 (Buscar dados do banco e mandar para a tela de edição)
    protected void buscarParaEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Entulho entulhoSelecionado = dao.selecionarEntulho(id);
        
        request.setAttribute("entulho", entulhoSelecionado);
        RequestDispatcher rd = request.getRequestDispatcher("editarColeta.jsp");
        rd.forward(request, response);
    }

    // UPDATE - Parte 2 (Receber as alterações da tela e salvar)
    protected void editarEntulho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Entulho entulhoEditado = new Entulho();
        entulhoEditado.setId(Integer.parseInt(request.getParameter("id")));
        entulhoEditado.setLogradouro(request.getParameter("logradouro"));
        entulhoEditado.setMaterial(request.getParameter("material"));
        entulhoEditado.setVolume(request.getParameter("volume"));
        
        dao.alterarEntulho(entulhoEditado);
        response.sendRedirect("main");
    }
}