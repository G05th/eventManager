/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.UsuarioDAO;
import dao.UsuarioPapelDAO;
import model.Usuario;
import util.PasswordUtil;
import java.sql.SQLException;
import java.util.List;
import util.Sessao;
/**
 *
 * @author ghost
 */
public class UsuarioController {

    private UsuarioDAO usuarioDAO;
    private UsuarioPapelDAO usuarioPapelDAO;

    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
        usuarioPapelDAO = new UsuarioPapelDAO();
    }

    public Usuario login(String email, String senha) {
        try {
            // Busca o usuário pelo email
            Usuario usuario = usuarioDAO.buscarPorEmail(email);
            // Verifica se o usuário existe e se a senha confere
            if (usuario != null && PasswordUtil.checkPassword(senha, usuario.getSenha())) {
                // Armazena o usuário logado na sessão
                Sessao.setUsuarioLogado(usuario);
                System.out.println("Login realizado com sucesso! Bem-vindo, " + usuario.getNome());
                return usuario;
            } else {
                System.out.println("Email ou senha inválidos!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean register(Usuario usuario, List<Integer> papeis) {
        try {
            // Criptografa a senha antes de salvar
            usuario.setSenha(PasswordUtil.hashPassword(usuario.getSenha()));
            // Salva o usuário no banco de dados
            usuarioDAO.salvar(usuario);
            // Associa cada papel ao usuário usando a tabela de associação
            for (Integer papelId : papeis) {
                usuarioPapelDAO.associar(usuario.getId(), papelId);
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
