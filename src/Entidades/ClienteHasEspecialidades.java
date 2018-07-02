/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "cliente_has_especialidades")
@NamedQueries({
    @NamedQuery(name = "ClienteHasEspecialidades.findAll", query = "SELECT c FROM ClienteHasEspecialidades c")})
public class ClienteHasEspecialidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClienteHasEspecialidadesPK clienteHasEspecialidadesPK;
    @Column(name = "problema_saude")
    private Boolean problemaSaude;
    @Column(name = "restricao")
    private Boolean restricao;
    @Column(name = "problema_respiracao")
    private Boolean problemaRespiracao;
    @Column(name = "qntd_secao")
    private Integer qntdSecao;
    @JoinColumn(name = "cliente_cpf", referencedColumnName = "cpf", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "id_especialidades", referencedColumnName = "id_especialidades", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Especialidades especialidades;

    public ClienteHasEspecialidades() {
    }

    public ClienteHasEspecialidades(ClienteHasEspecialidadesPK clienteHasEspecialidadesPK) {
        this.clienteHasEspecialidadesPK = clienteHasEspecialidadesPK;
    }

    public ClienteHasEspecialidades(String clienteCpf, int idEspecialidades) {
        this.clienteHasEspecialidadesPK = new ClienteHasEspecialidadesPK(clienteCpf, idEspecialidades);
    }

    public ClienteHasEspecialidadesPK getClienteHasEspecialidadesPK() {
        return clienteHasEspecialidadesPK;
    }

    public void setClienteHasEspecialidadesPK(ClienteHasEspecialidadesPK clienteHasEspecialidadesPK) {
        this.clienteHasEspecialidadesPK = clienteHasEspecialidadesPK;
    }

    public Boolean getProblemaSaude() {
        return problemaSaude;
    }

    public void setProblemaSaude(Boolean problemaSaude) {
        this.problemaSaude = problemaSaude;
    }

    public Boolean getRestricao() {
        return restricao;
    }

    public void setRestricao(Boolean restricao) {
        this.restricao = restricao;
    }

    public Boolean getProblemaRespiracao() {
        return problemaRespiracao;
    }

    public void setProblemaRespiracao(Boolean problemaRespiracao) {
        this.problemaRespiracao = problemaRespiracao;
    }

    public Integer getQntdSecao() {
        return qntdSecao;
    }

    public void setQntdSecao(Integer qntdSecao) {
        this.qntdSecao = qntdSecao;
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
        hash += (clienteHasEspecialidadesPK != null ? clienteHasEspecialidadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteHasEspecialidades)) {
            return false;
        }
        ClienteHasEspecialidades other = (ClienteHasEspecialidades) object;
        if ((this.clienteHasEspecialidadesPK == null && other.clienteHasEspecialidadesPK != null) || (this.clienteHasEspecialidadesPK != null && !this.clienteHasEspecialidadesPK.equals(other.clienteHasEspecialidadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ClienteHasEspecialidades[ clienteHasEspecialidadesPK=" + clienteHasEspecialidadesPK + " ]";
    }
    
}
