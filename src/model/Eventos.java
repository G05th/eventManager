/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @author ghost
 */
public class Eventos {
    private Long id;
    private String nome;
    private Date data;
    private String local;
    private String descricao;
    private String caminhoImagem;
    private Long organizador_id;
    
    public Eventos(){}
    
    public Eventos(Long id, String nome, Date data, String local, String descicao, String caminhoImagem, Long organizador_id){
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.descricao = descricao;
        this.caminhoImagem = caminhoImagem;
        this.organizador_id = organizador_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Long getOrganizador_id() {
        return organizador_id;
    }

    public void setOrganizador_id(Long usuario_id) {
        this.organizador_id = usuario_id;
    }

    
    
}
