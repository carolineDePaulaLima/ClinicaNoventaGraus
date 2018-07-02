/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cássio
 */
@Embeddable
public class ClienteHasHorarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cliente_cpf")
    private String clienteCpf;
    @Basic(optional = false)
    @Column(name = "id_horario")
    private String idHorario;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @Column(name = "id_especialidades")
    private int idEspecialidades;

    public ClienteHasHorarioPK() {
    }

    public ClienteHasHorarioPK(String clienteCpf, String idHorario, Date data, int idEspecialidades) {
        this.clienteCpf = clienteCpf;
        this.idHorario = idHorario;
        this.data = data;
        this.idEspecialidades = idEspecialidades;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    public String getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        hash += (data != null ? data.hashCode() : 0);
        hash += (int) idEspecialidades;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteHasHorarioPK)) {
            return false;
        }
        ClienteHasHorarioPK other = (ClienteHasHorarioPK) object;
        if ((this.clienteCpf == null && other.clienteCpf != null) || (this.clienteCpf != null && !this.clienteCpf.equals(other.clienteCpf))) {
            return false;
        }
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        if ((this.data == null && other.data != null) || (this.data != null && !this.data.equals(other.data))) {
            return false;
        }
        if (this.idEspecialidades != other.idEspecialidades) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ClienteHasHorarioPK[ clienteCpf=" + clienteCpf + ", idHorario=" + idHorario + ", data=" + data + ", idEspecialidades=" + idEspecialidades + " ]";
    }
    
}
