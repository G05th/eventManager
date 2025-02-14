package model;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Modelo de tabela para exibição de eventos.
 */
public class EventoTableModel extends AbstractTableModel {

    private final List<Eventos> eventos;
    private final String[] colunas = {"ID", "Nome", "Data", "Local", "Descrição"};

    public EventoTableModel(List<Eventos> eventos) {
        this.eventos = eventos;
    }

    @Override
    public int getRowCount() {
        return eventos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Eventos evento = eventos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return evento.getId();
            case 1:
                return evento.getNome();
            case 2:
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                return evento.getData() != null ? sdf.format(evento.getData()) : "";
            case 3:
                return evento.getLocal();
            case 4:
                return evento.getDescricao();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    /**
     * Retorna o objeto Eventos correspondente à linha especificada.
     * @param row Índice da linha na tabela
     * @return Objeto Eventos correspondente
     * @throws IndexOutOfBoundsException Se o índice estiver fora do intervalo válido
     */
    public Eventos getEventoAt(int row) {
        if (row >= 0 && row < eventos.size()) {
            return eventos.get(row);
        } else {
            throw new IndexOutOfBoundsException("Índice de linha inválido: " + row);
        }
    }
}
