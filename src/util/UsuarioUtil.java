/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.util.List;
import model.Usuario;
import model.UsuarioPapel;
/**
 *
 * @author ghost
 */
public class UsuarioUtil {

    /**
     * Verifica se o usuário possui ambos os papéis: ORGANIZADOR e PARTICIPANTE.
     * @param usuario O usuário a ser verificado.
     * @param listaUsuarioPapel Lista de associações entre usuários e papéis.
     * @return true se o usuário tiver ambos os papéis, false caso contrário.
     */
    public static boolean possuiAmbosPapeis(Usuario usuario, List<UsuarioPapel> listaUsuarioPapel) {
        boolean temOrganizador = false;
        boolean temParticipante = false;
        
        for (UsuarioPapel up : listaUsuarioPapel) {
            // Verifica se a associação é do usuário em questão
            if (up.getUsuario().getId().equals(usuario.getId())) {
                String descricaoPapel = up.getPapel().getDescricao();
                if ("ORGANIZADOR".equalsIgnoreCase(descricaoPapel)) {
                    temOrganizador = true;
                }
                if ("PARTICIPANTE".equalsIgnoreCase(descricaoPapel)) {
                    temParticipante = true;
                }
            }
        }
        
        return temOrganizador && temParticipante;
    }
}