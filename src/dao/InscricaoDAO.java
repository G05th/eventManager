/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Inscricao;
import model.Usuario;
import util.ConnectionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ghost
 */
public class InscricaoDAO {
    // Salva ou atualiza uma inscrição
    public void salvar(Inscricao inscricao) throws SQLException {
        Connection con = ConnectionBD.getConnection();
        try {
            String sql;
            if (inscricao.getId() == null) {
                sql = "INSERT INTO inscricao (evento_id, usuario_id, dataInscricao) VALUES (?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setLong(1, inscricao.getEventoId());
                stmt.setLong(2, inscricao.getUsuarioId());
                stmt.setDate(3, new java.sql.Date(inscricao.getDataInscricao().getTime()));
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    inscricao.setId(rs.getLong(1));
                }
                rs.close();
                stmt.close();
            } else {
                sql = "UPDATE inscricao SET evento_id=?, usuario_id=?, dataInscricao=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setLong(1, inscricao.getEventoId());
                stmt.setLong(2, inscricao.getUsuarioId());
                stmt.setDate(3, new java.sql.Date(inscricao.getDataInscricao().getTime()));
                stmt.setLong(4, inscricao.getId());
                stmt.executeUpdate();
                stmt.close();
            }
        } finally {
            con.close();
        }
    }

    // Busca uma inscrição pelo ID
    public Inscricao buscarPorId(Long id) throws SQLException {
        Inscricao inscricao = null;
        Connection con = ConnectionBD.getConnection();
        try {
            String sql = "SELECT * FROM inscricao WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                inscricao = new Inscricao();
                inscricao.setId(rs.getLong("id"));
                inscricao.setEventoId(rs.getLong("evento_id"));
                inscricao.setUsuarioId(rs.getLong("usuario_id"));
                inscricao.setDataInscricao(rs.getDate("dataInscricao"));
            }
            rs.close();
            stmt.close();
        } finally {
            con.close();
        }
        return inscricao;
    }

    // Lista todas as inscrições
    public List<Inscricao> listar() throws SQLException {
        List<Inscricao> inscricoes = new ArrayList<>();
        Connection con = ConnectionBD.getConnection();
        try {
            String sql = "SELECT * FROM inscricao";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Inscricao inscricao = new Inscricao();
                inscricao.setId(rs.getLong("id"));
                inscricao.setEventoId(rs.getLong("evento_id"));
                inscricao.setUsuarioId(rs.getLong("usuario_id"));
                inscricao.setDataInscricao(rs.getDate("dataInscricao"));
                inscricoes.add(inscricao);
            }
            rs.close();
            stmt.close();
        } finally {
            con.close();
        }
        return inscricoes;
    }
    
    public List<Usuario> listarParticipantesPorEvento(Long eventoId) throws SQLException {
        List<Usuario> participantes = new ArrayList<>();
        // A query realiza um JOIN entre as tabelas "inscricao" e "usuario"
        String sql = "SELECT u.id, u.nome, u.email " +
                     "FROM inscricao i " +
                     "JOIN usuario u ON i.usuario_id = u.id " +
                     "WHERE i.evento_id = ?";
        try (Connection con = ConnectionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, eventoId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getLong("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    participantes.add(usuario);
                }
            }
        }
        return participantes;
    }

    // Remove uma inscrição pelo ID
    public void remover(Long id) throws SQLException {
        Connection con = ConnectionBD.getConnection();
        try {
            String sql = "DELETE FROM inscricao WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            stmt.close();
        } finally {
            con.close();
        }
    }
    
    public boolean removerInscricaoPorEventoEUsuario(Long eventoId, Long usuarioId) throws SQLException {
    Connection con = ConnectionBD.getConnection();
    try {
        String sql = "DELETE FROM inscricao WHERE evento_id = ? AND usuario_id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setLong(1, eventoId);
        stmt.setLong(2, usuarioId);
        int linhasAfetadas = stmt.executeUpdate();
        stmt.close();
        return linhasAfetadas > 0;
    } finally {
        con.close();
    }
}

}