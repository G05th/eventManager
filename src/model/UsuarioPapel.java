package model;

public class UsuarioPapel {
    private Usuario usuario;
    private Papel papel;
    
    public UsuarioPapel() {}
    
    // Torne este construtor público
    public UsuarioPapel(Usuario usuario, Papel papel){
        this.usuario = usuario;
        this.papel = papel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }
}
