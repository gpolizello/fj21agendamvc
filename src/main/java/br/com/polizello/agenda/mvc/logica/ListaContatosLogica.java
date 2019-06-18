package br.com.polizello.agenda.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.polizello.agenda.dao.ContatoDao;
import br.com.polizello.agenda.modelo.Contato;

public class ListaContatosLogica implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response){

        Connection connection = (Connection)request.getAttribute("connection");

        ContatoDao dao = new ContatoDao(connection);
        List<Contato> contatos = dao.getLista();

        request.setAttribute("contatos", contatos);

        return "/WEB-INF/jsp/lista-contatos.jsp";
    }

}
