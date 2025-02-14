/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.Usuario;
import model.UsuarioPapel;

/**
 *
 * @author ghost
 */
public class Sessao {
    
    private static Usuario usuarioLogado;
    private static UsuarioPapel usuarioPapelLogado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        Sessao.usuarioLogado = usuarioLogado;
    }

    public static UsuarioPapel getUsuarioPapelLogado() {
        return usuarioPapelLogado;
    }

    public static void setUsuarioPapelLogado(UsuarioPapel usuarioPapelLogado) {
        Sessao.usuarioPapelLogado = usuarioPapelLogado;
    }
    
    
}
