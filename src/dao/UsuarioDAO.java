/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Usuario;
import util.ConnectionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ghost
 */
public class UsuarioDAO {


    // Salva ou atualiza um usuário
    public void salvar(Usuario usuario) throws SQLException {
        try (Connection con = ConnectionBD.getConnection()) {
            String sql;
            if (usuario.getId() == null) {
                sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, usuario.getNome());
                    stmt.setString(2, usuario.getEmail());
                    stmt.setString(3, usuario.getSenha());
                    stmt.executeUpdate();
                    try (ResultSet rs = stmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            usuario.setId(rs.getLong(1));
                        }
                    }
                }
            } else {
                sql = "UPDATE usuario SET nome=?, email=?, senha=? WHERE id=?";
                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                    stmt.setString(1, usuario.getNome());
                    stmt.setString(2, usuario.getEmail());
                    stmt.setString(3, usuario.getSenha());
                    stmt.setLong(4, usuario.getId());
                    stmt.executeUpdate();
                }
            }
        }
    }

    // Busca um usuário pelo ID
    public Usuario buscarPorId(Long id) throws SQLException {
        Usuario usuario = null;
        try (Connection con = ConnectionBD.getConnection()) {
            String sql = "SELECT * FROM usuario WHERE id = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setLong(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        usuario = new Usuario();
                        usuario.setId(rs.getLong("id"));
                        usuario.setNome(rs.getString("nome"));
                        usuario.setEmail(rs.getString("email"));
                        usuario.setSenha(rs.getString("senha"));
                    }
                }
            }
        }
        return usuario;
    }

    // Busca um usuário pelo email
    public Usuario buscarPorEmail(String email) throws SQLException {
        Usuario usuario = null;
        try (Connection con = ConnectionBD.getConnection()) {
            String sql = "SELECT * FROM usuario WHERE email = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, email);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        usuario = new Usuario();
                        usuario.setId(rs.getLong("id"));
                        usuario.setNome(rs.getString("nome"));
                        usuario.setEmail(rs.getString("email"));
                        usuario.setSenha(rs.getString("senha"));
                    }
                }
            }
        }
        return usuario;
    }

    // Lista todos os usuários
    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection con = ConnectionBD.getConnection()) {
            String sql = "SELECT * FROM usuario";
            try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getLong("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    usuarios.add(usuario);
                }
            }
        }
        return usuarios;
    }

    // Remove um usuário pelo ID
    public void remover(Long id) throws SQLException {
        try (Connection con = ConnectionBD.getConnection()) {
            String sql = "DELETE FROM usuario WHERE id = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setLong(1, id);
                stmt.executeUpdate();
            }
        }
    }
}
