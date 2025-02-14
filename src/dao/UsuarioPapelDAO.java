package dao;

import model.Papel;
import model.Usuario;
import model.UsuarioPapel;
import util.ConnectionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para gerenciar a associação entre Usuário e Papel.
 */
public class UsuarioPapelDAO {

    /**
     * Associa um papel a um usuário.
     * 
     * @param usuarioId O ID do usuário.
     * @param papelId   O ID do papel.
     * @throws SQLException Caso ocorra algum erro durante a operação.
     */
    public void associar(Long usuarioId, int papelId) throws SQLException {
        String sql = "INSERT INTO usuario_papel (usuario_id, papel_id) VALUES (?, ?)";
        try (Connection con = ConnectionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, usuarioId);
            stmt.setInt(2, papelId);
            stmt.executeUpdate();
        }
    }

    /**
     * Lista os papéis associados a um usuário.
     * 
     * @param usuarioId O ID do usuário.
     * @return Uma lista de UsuarioPapel representando os papéis associados.
     * @throws SQLException Caso ocorra algum erro durante a consulta.
     */
    public List<UsuarioPapel> listarPapeisDoUsuario(Long usuarioId) throws SQLException {
        List<UsuarioPapel> papeis = new ArrayList<>();
        String sql = "SELECT p.id AS papel_id, p.descricao AS papel_descricao " +
                     "FROM usuario_papel up " +
                     "JOIN papel p ON up.papel_id = p.id " +
                     "WHERE up.usuario_id = ?";
        try (Connection con = ConnectionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Recupera o ID e a descrição do papel
                    Long papelId = rs.getLong("papel_id");
                    String papelDescricao = rs.getString("papel_descricao");

                    // Cria objetos básicos de Usuario e Papel
                    Usuario usuario = new Usuario();
                    usuario.setId(usuarioId);

                    Papel papel = new Papel();
                    papel.setId(papelId);
                    papel.setDescricao(papelDescricao); // Define a descrição do papel

                    papeis.add(new UsuarioPapel(usuario, papel));
                }
            }
        }
        return papeis;
    }

    /**
     * Remove uma associação específica entre um usuário e um papel.
     * 
     * @param usuarioId O ID do usuário.
     * @param papelId   O ID do papel a ser removido.
     * @throws SQLException Caso ocorra algum erro durante a remoção.
     */
    public void removerAssociacao(Long usuarioId, int papelId) throws SQLException {
        String sql = "DELETE FROM usuario_papel WHERE usuario_id = ? AND papel_id = ?";
        try (Connection con = ConnectionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, usuarioId);
            stmt.setInt(2, papelId);
            stmt.executeUpdate();
        }
    }
}