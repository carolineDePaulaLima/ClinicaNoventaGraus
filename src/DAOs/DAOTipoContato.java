package DAOs;


import Entidades.TipoContato;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOTipoContato extends DAOGenerico<TipoContato> {

    public DAOTipoContato() {
        super(TipoContato.class);
    }

    public int autoIdTipoContato() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idTipoContato) FROM TipoContato e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<TipoContato> listByNome(String nome) {
        return em.createQuery("SELECT e FROM TipoContato e WHERE e.nomeContato LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<TipoContato> listById(int id) {
        return em.createQuery("SELECT e FROM TipoContato e WHERE e.idTipoContato = :id").setParameter("id", id).getResultList();
    }

    public List<TipoContato> listInOrderNome() {
        return em.createQuery("SELECT e FROM TipoContato e ORDER BY e.nomeContato").getResultList();
    }

    public List<TipoContato> listInOrderId() {
        return em.createQuery("SELECT e FROM TipoContato e ORDER BY e.idTipoContato").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<TipoContato> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdTipoContato() + "-" + lf.get(i).getNomeContato());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOTipoContato daoTipoContato = new DAOTipoContato();
        List<TipoContato> listaTipoContato = daoTipoContato.list();
        for (TipoContato tipoContato : listaTipoContato) {
            System.out.println(tipoContato.getIdTipoContato() + "-" + tipoContato.getNomeContato());
        }
    }}
