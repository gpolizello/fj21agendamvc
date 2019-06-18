package br.com.polizello.agenda.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormAdicionaContatoLogica implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/jsp/adiciona-contato.jsp";
    }

}