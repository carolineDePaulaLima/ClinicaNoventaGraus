package GUIs;

import DAOs.DAOCliente;
import DAOs.DAOEspecialidades;
import Entidades.Cliente;
import Entidades.ClienteHasEspecialidades;
import Entidades.Especialidades;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import tools.CentroDoMonitorMaior;

public class GUIClienteEspecListagem extends JDialog {

    JPanel painelTa = new JPanel();
    JScrollPane scroll = new JScrollPane();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
    DAOCliente daoCliente = new DAOCliente();
    DAOEspecialidades daoEspecialidades = new DAOEspecialidades();
    Cliente cliente = new Cliente();
    Especialidades especialidades = new Especialidades();

    public GUIClienteEspecListagem(List<ClienteHasEspecialidades> texto) {
        if (texto == null) {
            System.out.println("aqui");
            return;
        }
        setTitle("Listagem de ClienteHasEspecialidades");
        setSize(1000, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.CYAN);
        setModal(true);
        Container cp = getContentPane();
        JToolBar toolBar = new JToolBar();
        String[] colunas = new String[]{"Cliente", "Especialidade", "Problema de saúde", "Restrição", "Problema de respiração", "Quantidade de Seções"};
        String[][] dados = new String[0][6];
        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        JTable tabela = new JTable(model);
        tabela.setEnabled(false);
        scroll.setViewportView(tabela);
        for (int i = 0; i < texto.size(); i++) {
            String idC = texto.get(i).getClienteHasEspecialidadesPK().getClienteCpf();
            cliente = daoCliente.obter(idC);
            int idP = Integer.valueOf(texto.get(i).getClienteHasEspecialidadesPK().getIdEspecialidades());
            especialidades = daoEspecialidades.obter(idP);
            String[] linha = new String[]{String.valueOf(cliente.getNome()),
                especialidades.getNomeEspecialidade(),
                String.valueOf(texto.get(i).getProblemaSaude()),
                String.valueOf(texto.get(i).getRestricao()),
                String.valueOf(texto.get(i).getProblemaRespiracao()),
                String.valueOf(texto.get(i).getQntdSecao()),};
            model.addRow(linha);
        }
        painelTa.add(scroll);
        cp.add(toolBar, BorderLayout.NORTH);
        cp.add(scroll, BorderLayout.CENTER);
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);
    }
}
