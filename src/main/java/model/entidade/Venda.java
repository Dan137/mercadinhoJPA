/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Daniel
 */
@Entity
public class Venda implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "idvenda", nullable = false)
    private Integer codVenda;
    
    @Column(name = "datavenda", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVenda;

    @Column(name = "prazopagamento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPagamento;

    @Column (name="valortot", nullable = false)
    private double valorTot;
    
    @Column(name = "formpag", nullable = false)
    private String formapagamento;
   
    @Transient
    private List<ItemVenda> itemvenda;
    
    @ManyToOne
    
    @JoinColumn(name = "cliente_id"
    )
    private Cliente cliente_id;

    public Venda() {
    }

    public Venda(Integer codVenda, Date dataVenda, Date dataPagamento, double valorTot, String formapagamento, Cliente cliente_id) {
        this.codVenda = codVenda;
        this.dataVenda = dataVenda;
        this.dataPagamento = dataPagamento;
        this.valorTot=valorTot;
        this.formapagamento = formapagamento;
        this.cliente_id = cliente_id;
    }

    public Integer getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorTot() {
        
        return valorTot;
    }

    public void setValorTot(double valorTot) {
        this.valorTot = valorTot;
    }
    
    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public List<ItemVenda> getItemvenda() {
        return itemvenda;
    }

    public void setItemvenda(List<ItemVenda> itemvenda) {
        this.itemvenda = itemvenda;
    }

    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codVenda);
        hash = 59 * hash + Objects.hashCode(this.dataVenda);
        hash = 59 * hash + Objects.hashCode(this.dataPagamento);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.valorTot) ^ (Double.doubleToLongBits(this.valorTot) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.formapagamento);
        hash = 59 * hash + Objects.hashCode(this.itemvenda);
        hash = 59 * hash + Objects.hashCode(this.cliente_id);
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
        final Venda other = (Venda) obj;
        if (Double.doubleToLongBits(this.valorTot) != Double.doubleToLongBits(other.valorTot)) {
            return false;
        }
        if (!Objects.equals(this.formapagamento, other.formapagamento)) {
            return false;
        }
        if (!Objects.equals(this.codVenda, other.codVenda)) {
            return false;
        }
        if (!Objects.equals(this.dataVenda, other.dataVenda)) {
            return false;
        }
        if (!Objects.equals(this.dataPagamento, other.dataPagamento)) {
            return false;
        }
        if (!Objects.equals(this.itemvenda, other.itemvenda)) {
            return false;
        }
        if (!Objects.equals(this.cliente_id, other.cliente_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "codVenda=" + codVenda + ", dataVenda=" + dataVenda + ", dataPagamento=" + dataPagamento + ", valorTot=" + valorTot + ", formapagamento=" + formapagamento + ", itemvenda=" + itemvenda + ", cliente_id=" + cliente_id + '}';
    }
    
    
    
}
