/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.ConnectionBD;
import model.Eventos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ghost
 */
public class EventoDAO {

    // Salva ou atualiza um evento
    public void salvar(Eventos evento) throws SQLException {
        Connection con = ConnectionBD.getConnection();
        try {
            String sql;
            if (evento.getId() == null) {
                sql = "INSERT INTO evento (nome, data, local, descricao, caminhoImagem, organizador_id) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, evento.getNome());
                stmt.setDate(2, new java.sql.Date(evento.getData().getTime()));
                stmt.setString(3, evento.getLocal());
                stmt.setString(4, evento.getDescricao());
                stmt.setString(5, evento.getCaminhoImagem());
                stmt.setLong(6, evento.getOrganizador_id());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    evento.setId(rs.getLong(1));
                }
                rs.close();
                stmt.close();
            } else {
                sql = "UPDATE evento SET nome=?, data=?, local=?, descricao=?, caminhoImagem=?, organizador_id=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, evento.getNome());
                stmt.setDate(2, new java.sql.Date(evento.getData().getTime()));
                stmt.setString(3, evento.getLocal());
                stmt.setString(4, evento.getDescricao());
                stmt.setString(5, evento.getCaminhoImagem());
                stmt.setLong(6, evento.getOrganizador_id());
                stmt.setLong(7, evento.getId());
                stmt.executeUpdate();
                stmt.close();
            }
        } finally {
            con.close();
        }
    }

    // Busca um evento pelo ID
    public Eventos buscarPorId(Long id) throws SQLException {
        Eventos evento = null;
        Connection con = ConnectionBD.getConnection();
        try {
            String sql = "SELECT * FROM evento WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                evento = new Eventos();
                evento.setId(rs.getLong("id"));
                evento.setNome(rs.getString("nome"));
                evento.setData(rs.getDate("data"));
                evento.setLocal(rs.getString("local"));
                evento.setDescricao(rs.getString("descricao"));
                evento.setCaminhoImagem(rs.getString("caminhoImagem"));
                evento.setOrganizador_id(rs.getLong("organizador_id"));
            }
            rs.close();
            stmt.close();
        } finally {
            con.close();
        }
        return evento;
    }

    // Lista todos os eventos
    public List<Eventos> listar() throws SQLException {
        List<Eventos> eventos = new ArrayList<>();
        Connection con = ConnectionBD.getConnection();
        try {
            String sql = "SELECT * FROM evento";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Eventos evento = new Eventos();
                evento.setId(rs.getLong("id"));
                evento.setNome(rs.getString("nome"));
                evento.setData(rs.getDate("data"));
                evento.setLocal(rs.getString("local"));
                evento.setDescricao(rs.getString("descricao"));
                evento.setCaminhoImagem(rs.getString("caminhoImagem"));
                evento.setOrganizador_id(rs.getLong("organizador_id"));
                eventos.add(evento);
            }
            rs.close();
            stmt.close();
        } finally {
            con.close();
        }
        return eventos;
    }

    // Remove um evento pelo ID
    public void remover(Long id) throws SQLException {
        Connection con = ConnectionBD.getConnection();
        try {
            String sql = "DELETE FROM evento WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            stmt.close();
        } finally {
            con.close();
        }
    }
}