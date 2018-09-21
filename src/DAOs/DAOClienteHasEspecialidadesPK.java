package DAOs;

import Entidades.ClienteHasEspecialidadesPK;
import java.util.ArrayList;
import java.util.List;

public class DAOClienteHasEspecialidadesPK extends DAOGenerico<ClienteHasEspecialidadesPK> {

    private List<ClienteHasEspecialidadesPK> lista = new ArrayList<>();

    public DAOClienteHasEspecialidadesPK() {
        super(ClienteHasEspecialidadesPK.class);
    }

    public static void main(String[] args) {
        DAOClienteHasEspecialidadesPK daoClienteHasEspecialidadesPK = new DAOClienteHasEspecialidadesPK();
        List<ClienteHasEspecialidadesPK> listaClienteHasEspecialidadesPK = daoClienteHasEspecialidadesPK.list();
        for (ClienteHasEspecialidadesPK clienteHasEspecialidadesPK : listaClienteHasEspecialidadesPK) {
            System.out.println(clienteHasEspecialidadesPK.getClienteCpf() + "-"
                    + clienteHasEspecialidadesPK.getIdEspecialidades());
        }
    }
}
