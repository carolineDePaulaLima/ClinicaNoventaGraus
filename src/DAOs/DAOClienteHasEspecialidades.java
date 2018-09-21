package DAOs;

import Entidades.ClienteHasEspecialidades;
import Entidades.ClienteHasEspecialidadesPK;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DAOClienteHasEspecialidades extends DAOGenerico<ClienteHasEspecialidades> {

    private List<ClienteHasEspecialidades> lista = new ArrayList<>();

    public DAOClienteHasEspecialidades() {
        super(ClienteHasEspecialidades.class);
    }

    public ClienteHasEspecialidades obter(ClienteHasEspecialidadesPK precoProdutoPK) {
        return em.find(ClienteHasEspecialidades.class, precoProdutoPK);
    }

    public List<ClienteHasEspecialidades> listByNome(String nome) {
        return em.createQuery("SELECT e FROM ClienteHasEspecialidades e WHERE e.especialidades.nomeEspecialidade LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<ClienteHasEspecialidades> listById(int id) {
        return em.createQuery("SELECT e FROM ClienteHasEspecialidades e WHERE e.clienteHasEspecialidadesPK.idEspecialidades = :id").setParameter("id", id).getResultList();
    }

    public List<ClienteHasEspecialidades> listInOrderNome() {
        return em.createQuery("SELECT e FROM ClienteHasEspecialidades e ORDER BY e.especialidades").getResultList();
    }

    public List<ClienteHasEspecialidades> listInOrderId() {
        return em.createQuery("SELECT e FROM ClienteHasEspecialidades e ORDER BY e.clienteHasEspecialidadesPK.idEspecialidades").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<ClienteHasEspecialidades> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getClienteHasEspecialidadesPK().getClienteCpf() + "-"
                    + lf.get(i).getClienteHasEspecialidadesPK().getIdEspecialidades() + "-"
                    + lf.get(i).getProblemaSaude() + "-"
                    + lf.get(i).getRestricao() + "-"
                    + lf.get(i).getProblemaRespiracao() + "-"
                    + lf.get(i).getQntdSecao());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOClienteHasEspecialidades daoClienteHasEspecialidades = new DAOClienteHasEspecialidades();
        List<ClienteHasEspecialidades> listaClienteHasEspecialidades = daoClienteHasEspecialidades.list();
        for (ClienteHasEspecialidades clienteHasEspecialidade : listaClienteHasEspecialidades) {
            System.out.println(clienteHasEspecialidade.getCliente().getNome() + "-" 
                    + clienteHasEspecialidade.getEspecialidades().getNomeEspecialidade());
        }
    }
}