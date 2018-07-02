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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Cássio
 */
@Entity
@Table(name = "especialidades")
@NamedQueries({
    @NamedQuery(name = "Especialidades.findAll", query = "SELECT e FROM Especialidades e")})
public class Especialidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_especialidades")
    private Integer idEspecialidades;
    @Column(name = "nome_especialidade")
    private String nomeEspecialidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidades")
    private List<ClienteHasHorario> clienteHasHorarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidades")
    private List<ClienteHasEspecialidades> clienteHasEspecialidadesList;

    public Especialidades() {
    }

    public Especialidades(Integer idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    public Integer getIdEspecialidades() {
        return idEspecialidades;
    }

    public void setIdEspecialidades(Integer idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public List<ClienteHasHorario> getClienteHasHorarioList() {
        return clienteHasHorarioList;
    }

    public void setClienteHasHorarioList(List<ClienteHasHorario> clienteHasHorarioList) {
        this.clienteHasHorarioList = clienteHasHorarioList;
    }

    public List<ClienteHasEspecialidades> getClienteHasEspecialidadesList() {
        return clienteHasEspecialidadesList;
    }

    public void setClienteHasEspecialidadesList(List<ClienteHasEspecialidades> clienteHasEspecialidadesList) {
        this.clienteHasEspecialidadesList = clienteHasEspecialidadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecialidades != null ? idEspecialidades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidades)) {
            return false;
        }
        Especialidades other = (Especialidades) object;
        if ((this.idEspecialidades == null && other.idEspecialidades != null) || (this.idEspecialidades != null && !this.idEspecialidades.equals(other.idEspecialidades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idEspecialidades + "-" + nomeEspecialidade;
    }
    
}
