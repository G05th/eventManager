/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ghost
 */
public class ConnectionBD {
    private static final String URL = "jdbc:mysql://localhost/gerenciamento_eventos"; // URL do banco de dados
    private static final String USER = "ghost";                      // Usuário do banco de dados
    private static final String PASSWORD = "1234567890";             // Senha do banco de dados

    // Método estático para obter a conexão
    public static java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, "Erro na conexão com o banco de dados", ex);
        }
        return connection;
    }
    
}
