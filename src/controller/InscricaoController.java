/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.InscricaoDAO;
import model.Inscricao;
import model.Usuario;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author ghost
 */
public class InscricaoController {

    private InscricaoDAO inscricaoDAO;

    public InscricaoController() {
        inscricaoDAO = new InscricaoDAO();
    }

    /**
     * Salva ou atualiza uma inscrição.
     * @param inscricao Objeto Inscricao com os dados da inscrição.
     * @return true se a operação for bem-sucedida; false caso contrário.
     */
    public boolean salvarInscricao(Inscricao inscricao) {
        try {
            inscricaoDAO.salvar(inscricao);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Busca uma inscrição pelo ID.
     * @param id ID da inscrição.
     * @return Objeto Inscricao, se encontrado; caso contrário, null.
     */
    public Inscricao buscarInscricao(Long id) {
        try {
            return inscricaoDAO.buscarPorId(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Lista todas as inscrições.
     * @return Lista de inscrições.
     */
    public List<Inscricao> listarInscricoes() {
        try {
            return inscricaoDAO.listar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Usuario> listarParticipantesPorEvento(Long eventoId) {
        try {
            return inscricaoDAO.listarParticipantesPorEvento(eventoId);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    /**
     * Remove uma inscrição pelo ID.
     * @param id ID da inscrição a ser removida.
     * @return true se a remoção for bem-sucedida; false caso contrário.
     */
    public boolean removerInscricao(Long id) {
        try {
            inscricaoDAO.remover(id);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean removerInscricaoDoEvento(Long eventoId, Long usuarioId) {
    try {
        return inscricaoDAO.removerInscricaoPorEventoEUsuario(eventoId, usuarioId);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}

}