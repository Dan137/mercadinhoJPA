/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 *
 * @author Daniel
 */
@Entity
@NamedQueries({
    @NamedQuery (name="Usuario.autenticar", 
            query="SELECT usuario FROM Usuario usuario WHERE usuario.senha = :senha AND usuario.user= :user")
})

public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_usuario;
    
    @Column(name="login", unique = true)
    private String user;
    
    @Column(name="senha")
    private String senha;
    
    @Column(name="email")
    private String email;

    public Usuario() {
    }

    public Usuario(Integer id_usuario, String user, String senha, String email) {
        this.id_usuario=id_usuario;
        this.user = user;
        this.senha = senha;
        this.email=email;
        
    }
  

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", user=" + user + ", senha=" + senha + '}';
    }
}
