package br.com.polizello.agenda.mvc.servlet;

import br.com.polizello.agenda.mvc.logica.Logica;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String parametro = request.getParameter("logica");
        String nomeDaClasse = "br.com.polizello.agenda.mvc.logica." + parametro;

        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Logica logica = (Logica) classe.newInstance();

            String pagina = logica.executa(request, response);
            request.getRequestDispatcher(pagina).forward(request, response);

        } catch (Exception err) {
            throw new ServletException("A lógica de negócios causou uma exceção.", err);
        }
    }

}