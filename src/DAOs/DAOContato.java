package DAOs;


import Entidades.Contato;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOContato extends DAOGenerico<Contato> {

    public DAOContato() {
        super(Contato.class);
    }

    public int autoIdContato() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idContato) FROM Contato e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Contato> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Contato e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Contato> listById(int id) {
        return em.createQuery("SELECT e FROM Contato e WHERE e.contato = :id").setParameter("id", id).getResultList();
    }

    public List<Contato> listInOrderNome() {
        return em.createQuery("SELECT e FROM Contato e ORDER BY e.nome").getResultList();
    }

    public List<Contato> listInOrderId() {
        return em.createQuery("SELECT e FROM Contato e ORDER BY e.contato").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Contato> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getContato() + "-" + lf.get(i).getNome());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOContato daoContato = new DAOContato();
        List<Contato> listaContato = daoContato.list();
        for (Contato contato : listaContato) {
            System.out.println(contato.getContato() + "-" + contato.getNome());
        }
    }}
