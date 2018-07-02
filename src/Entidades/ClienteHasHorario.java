/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Cássio
 */
@Entity
@Table(name = "cliente_has_horario")
@NamedQueries({
    @NamedQuery(name = "ClienteHasHorario.findAll", query = "SELECT c FROM ClienteHasHorario c")})
public class ClienteHasHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClienteHasHorarioPK clienteHasHorarioPK;
    @JoinColumn(name = "id_horario", referencedColumnName = "id_horario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Horario horario;
    @JoinColumn(name = "cliente_cpf", referencedColumnName = "cpf", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "id_especialidades", referencedColumnName = "id_especialidades", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Especialidades especialidades;

    public ClienteHasHorario() {
    }

    public ClienteHasHorario(ClienteHasHorarioPK clienteHasHorarioPK) {
        this.clienteHasHorarioPK = clienteHasHorarioPK;
    }

    public ClienteHasHorario(String clienteCpf, String idHorario, Date data, int idEspecialidades) {
        this.clienteHasHorarioPK = new ClienteHasHorarioPK(clienteCpf, idHorario, data, idEspecialidades);
    }

    public ClienteHasHorarioPK getClienteHasHorarioPK() {
        return clienteHasHorarioPK;
    }

    public void setClienteHasHorarioPK(ClienteHasHorarioPK clienteHasHorarioPK) {
        this.clienteHasHorarioPK = clienteHasHorarioPK;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Especialidades getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Especialidades especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteHasHorarioPK != null ? clienteHasHorarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteHasHorario)) {
            return false;
        }
        ClienteHasHorario other = (ClienteHasHorario) object;
        if ((this.clienteHasHorarioPK == null && other.clienteHasHorarioPK != null) || (this.clienteHasHorarioPK != null && !this.clienteHasHorarioPK.equals(other.clienteHasHorarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ClienteHasHorario[ clienteHasHorarioPK=" + clienteHasHorarioPK + " ]";
    }
    
}
