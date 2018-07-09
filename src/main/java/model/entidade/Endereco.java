/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 *
 * @author Daniel
 */
//@Entity()
//@Table(name="endereco")
@Embeddable
public class Endereco implements Serializable{
    
    @Column (name="numero", unique = true)
    private int numero;
    
    @Column( name="rua", nullable = false)
    private String rua;
    
    @Column(name="bairro", nullable = false)
    private String bairro;
    
    @Column(name="cidade", nullable = false)
    private String cidade;
    
    @Column(name="cep", nullable = false)
    private String cep;
    

    public Endereco(String rua, int numero, String bairro, String cidade, String cep) {
        
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        
    }

    public Endereco() {
    }
    
    
    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.numero;
        hash = 29 * hash + Objects.hashCode(this.rua);
        hash = 29 * hash + Objects.hashCode(this.bairro);
        hash = 29 * hash + Objects.hashCode(this.cidade);
        hash = 29 * hash + Objects.hashCode(this.cep);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "numero=" + numero + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + '}';
    }
   
    
    
}
