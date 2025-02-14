/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import model.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ghost
 */

public class ParticipanteTableModel extends AbstractTableModel {

    private final List<Usuario> participantes;
    private final String[] colunas = {"ID", "Nome", "Email"};

    public ParticipanteTableModel(List<Usuario> participantes) {
        this.participantes = participantes;
    }

    @Override
    public int getRowCount() {
        return participantes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario participante = participantes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return participante.getId();
            case 1:
                return participante.getNome();
            case 2:
                return participante.getEmail();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    // Método auxiliar para obter o participante selecionado
    public Usuario getParticipanteAt(int rowIndex) {
        return participantes.get(rowIndex);
    }
}