/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Cássio
 */
@Embeddable
public class ClienteHasEspecialidadesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cliente_cpf")
    private String clienteCpf;
    @Basic(optional = false)
    @Column(name = "id_especialidades")
    private int idEspecialidades;

    public ClienteHasEspecialidadesPK() {
    }

    public ClienteHasEspecialidadesPK(String clienteCpf, int idEspecialidades) {
        this.clienteCpf = clienteCpf;
        this.idEspecialidades = idEspecialidades;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    public int getIdEspecialidades() {
        return idEspecialidades;
    }

    public void setIdEspecialidades(int idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteCpf != null ? clienteCpf.hashCode() : 0);
        hash += (int) idEspecialidades;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteHasEspecialidadesPK)) {
            return false;
        }
        ClienteHasEspecialidadesPK other = (ClienteHasEspecialidadesPK) object;
        if ((this.clienteCpf == null && other.clienteCpf != null) || (this.clienteCpf != null && !this.clienteCpf.equals(other.clienteCpf))) {
            return false;
        }
        if (this.idEspecialidades != other.idEspecialidades) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ClienteHasEspecialidadesPK[ clienteCpf=" + clienteCpf + ", idEspecialidades=" + idEspecialidades + " ]";
    }
    
}
