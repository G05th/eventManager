/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.EventoDAO;
import model.Eventos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ghost
 */
public class EventoController {

    private EventoDAO eventoDAO;

    public EventoController() {
        eventoDAO = new EventoDAO();
    }

    /**
     * Salva ou atualiza um evento.
     * @param evento Objeto Evento com os dados do evento.
     * @return true se a operação for bem-sucedida; false caso contrário.
     */
    public boolean salvarEvento(Eventos evento) {
        try {
            eventoDAO.salvar(evento);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Busca um evento pelo ID.
     * @param id ID do evento.
     * @return O objeto Evento, se encontrado; caso contrário, null.
     */
    public Eventos buscarEvento(Long id) {
        try {
            return eventoDAO.buscarPorId(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Lista todos os eventos.
     * @return Lista de objetos Evento.
     */
    public List<Eventos> listarEventos() {
    try {
        return eventoDAO.listar();
    } catch (SQLException ex) {
        ex.printStackTrace();
        return new ArrayList<>();
    }
}
    public List<Eventos> listarEventosPorOrganizador(Long organizadorId) {
    try {
        List<Eventos> todosEventos = eventoDAO.listar();
        List<Eventos> eventosOrganizador = new ArrayList<>();
        for (Eventos e : todosEventos) {
            if (e.getOrganizador_id().equals(organizadorId)) {
                eventosOrganizador.add(e);
            }
        }
        return eventosOrganizador;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return new ArrayList<>();
    }
}


    /**
     * Remove um evento pelo ID.
     * @param id ID do evento a ser removido.
     * @return true se a remoção for bem-sucedida; false caso contrário.
     */
    public boolean removerEvento(Long id) {
        try {
            eventoDAO.remover(id);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}