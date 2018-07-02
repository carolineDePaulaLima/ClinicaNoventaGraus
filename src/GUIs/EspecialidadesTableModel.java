package GUIs;

import Entidades.Especialidades;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class EspecialidadesTableModel extends AbstractTableModel {

    private final Class classes[] = new Class[]{Integer.class, String.class};
    private final String colunas[] = new String[]{"id", "Nome"};
    private List<Especialidades> dados;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //private final SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");

    public EspecialidadesTableModel(List<Especialidades> dados) {
        this.dados = dados;
    }

    public void setDados(List<Especialidades> dados) {
        this.dados = dados;
    }

    public List<Especialidades> getDados() {
        return this.dados;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Especialidades s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getIdEspecialidades();
            case 1:
                return s.getNomeEspecialidade();
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        //  mudou = true;
        Especialidades s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                s.setIdEspecialidades((Integer) aValue);
                break;
            case 1:
                s.setNomeEspecialidade((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
        fireTableDataChanged();
    }

    public Especialidades getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    public int indexOf(Especialidades tc) {
        return dados.indexOf(tc);
    }

    public void onAdd(Especialidades especialidades) {
        dados.add(especialidades);
        fireTableRowsInserted(indexOf(especialidades), indexOf(especialidades));
    }

    public void onRemove(int[] rowIndex) {
        int x;
        for (x = rowIndex.length - 1; x >= 0; x--) {
            dados.remove(rowIndex[x]);
            fireTableRowsDeleted(rowIndex[x], rowIndex[x]);
        }
    }
}
