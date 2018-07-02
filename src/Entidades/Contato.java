/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Cássio
 */
@Entity
@Table(name = "contato")
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c")})
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "contato")
    private String contato;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contato")
    private List<Cliente> clienteList;
    @JoinColumn(name = "id_tipo_contato", referencedColumnName = "id_tipo_contato")
    @ManyToOne(optional = false)
    private TipoContato idTipoContato;

    public Contato() {
    }

    public Contato(String contato) {
        this.contato = contato;
    }

    public Contato(String contato, String nome) {
        this.contato = contato;
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public TipoContato getIdTipoContato() {
        return idTipoContato;
    }

    public void setIdTipoContato(TipoContato idTipoContato) {
        this.idTipoContato = idTipoContato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contato != null ? contato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.contato == null && other.contato != null) || (this.contato != null && !this.contato.equals(other.contato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return contato + "-" + nome;
    }
    
}
