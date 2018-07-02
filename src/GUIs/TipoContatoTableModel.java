package GUIs;

import Entidades.TipoContato;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TipoContatoTableModel extends AbstractTableModel {

    private final Class classes[] = new Class[]{Integer.class, String.class};
    private final String colunas[] = new String[]{"id", "Nome"};
    private List<TipoContato> dados;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //private final SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");

    public TipoContatoTableModel(List<TipoContato> dados) {
        this.dados = dados;
    }

    public void setDados(List<TipoContato> dados) {
        this.dados = dados;
    }

    public List<TipoContato> getDados() {
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

        TipoContato s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getIdTipoContato();
            case 1:
                return s.getNomeContato();
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
        TipoContato s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                s.setIdTipoContato((Integer) aValue);
                break;
            case 1:
                s.setNomeContato((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
        fireTableDataChanged();
    }

    public TipoContato getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    public int indexOf(TipoContato tc) {
        return dados.indexOf(tc);
    }

    public void onAdd(TipoContato tipoContato) {
        dados.add(tipoContato);
        fireTableRowsInserted(indexOf(tipoContato), indexOf(tipoContato));
    }

    public void onRemove(int[] rowIndex) {
        int x;
        for (x = rowIndex.length - 1; x >= 0; x--) {
            dados.remove(rowIndex[x]);
            fireTableRowsDeleted(rowIndex[x], rowIndex[x]);
        }
    }
}
