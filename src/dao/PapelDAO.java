/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Papel;
import util.ConnectionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ghost
 */
public class PapelDAO {


    // Salva ou atualiza um papel
    public void salvar(Papel papel) throws SQLException {
        Connection con = ConnectionBD.getConnection();
        try {
            String sql;
            if (papel.getId() == null) {
                sql = "INSERT INTO papel (descricao) VALUES (?)";
                PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, papel.getDescricao());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    papel.setId(rs.getLong(1));
                }
                rs.close();
                stmt.close();
            } else {
                sql = "UPDATE papel SET descricao=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, papel.getDescricao());
                stmt.setLong(2, papel.getId());
                stmt.executeUpdate();
                stmt.close();
            }
        } finally {
            con.close();
        }
    }

    // Busca um papel pelo ID
    public Papel buscarPorId(int id) throws SQLException {
        Papel papel = null;
        Connection con = ConnectionBD.getConnection();
        try {
            String sql = "SELECT * FROM papel WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                papel = new Papel();
                papel.setId(rs.getLong("id"));
                papel.setDescricao(rs.getString("descricao"));
            }
            rs.close();
            stmt.close();
        } finally {
            con.close();
        }
        return papel;
    }

    // Lista todos os papéis
    public List<Papel> listar() throws SQLException {
        List<Papel> papeis = new ArrayList<>();
        Connection con = ConnectionBD.getConnection();
        try {
            String sql = "SELECT * FROM papel";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Papel papel = new Papel();
                papel.setId(rs.getLong("id"));
                papel.setDescricao(rs.getString("descricao"));
                papeis.add(papel);
            }
            rs.close();
            stmt.close();
        } finally {
            con.close();
        }
        return papeis;
    }

    // Remove um papel pelo ID
    public void remover(int id) throws SQLException {
        Connection con = ConnectionBD.getConnection();
        try {
            String sql = "DELETE FROM papel WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } finally {
            con.close();
        }
    }
}