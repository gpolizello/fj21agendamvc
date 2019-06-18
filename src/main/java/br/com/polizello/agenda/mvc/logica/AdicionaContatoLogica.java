package br.com.polizello.agenda.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.polizello.agenda.dao.ContatoDao;
import br.com.polizello.agenda.modelo.Contato;

public class AdicionaContatoLogica implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String datanascimento = request.getParameter("datanascimento");

        Date dtNasc = null;
        try{
            dtNasc = new SimpleDateFormat("dd/MM/yyyy").parse(datanascimento);
        }catch(ParseException err){
            err.printStackTrace();
            return null;
        }

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);
        contato.setDatanascimento(dtNasc);

        Connection connection = (Connection)request.getAttribute("connection");

        ContatoDao dao = new ContatoDao(connection);
        dao.adicionaContato(contato);

        request.setAttribute("nome", nome);

        return "/WEB-INF/jsp/contato-adicionado.jsp";
    }

}