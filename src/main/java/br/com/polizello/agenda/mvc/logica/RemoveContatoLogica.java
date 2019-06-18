package br.com.polizello.agenda.mvc.logica;

import br.com.polizello.agenda.dao.ContatoDao;
import br.com.polizello.agenda.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class RemoveContatoLogica implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {

        Long id = Long.parseLong(request.getParameter("id"));

        Contato contato = new Contato();
        contato.setId(id);

        Connection connection = (Connection)request.getAttribute("connection");

        ContatoDao dao = new ContatoDao(connection);
        dao.remove(contato);

        return "/WEB-INF/jsp/contato-removido.jsp";
    }

}