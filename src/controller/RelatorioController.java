/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Eventos;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
/**
 *
 * @author ghost
 */
public class RelatorioController {

    /**
     * Gera um relatório em PDF com a lista de eventos.
     * 
     * @param eventos      Lista de eventos a serem incluídos no relatório.
     * @param caminhoArquivo Caminho completo (incluindo o nome do arquivo) onde o PDF será salvo.
     * @return true se o relatório for gerado com sucesso; false caso contrário.
     */
    public boolean gerarRelatorioEventos(List<Eventos> eventos, String caminhoArquivo) {
        // Cria um documento PDF
        Document document = new Document();
        try {
            // Cria uma instância do PdfWriter para salvar o documento no caminho especificado
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();
            
            // Adiciona um título ao relatório
            document.add(new Paragraph("Relatório de Eventos"));
            document.add(new Paragraph(" ")); // Linha em branco para espaçamento

            // Define uma tabela com 5 colunas: ID, Nome, Data, Local e Descrição
            PdfPTable table = new PdfPTable(5);
            table.addCell("ID");
            table.addCell("Nome");
            table.addCell("Data");
            table.addCell("Local");
            table.addCell("Descrição");

            // Formata a data para uma exibição amigável
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            // Itera sobre os eventos e adiciona uma linha para cada evento na tabela
            for (Eventos evento : eventos) {
                table.addCell(String.valueOf(evento.getId()));
                table.addCell(evento.getNome());
                // Verifica se a data não é nula
                String dataFormatada = evento.getData() != null ? sdf.format(evento.getData()) : "";
                table.addCell(dataFormatada);
                table.addCell(evento.getLocal());
                table.addCell(evento.getDescricao());
            }
            
            // Adiciona a tabela ao documento
            document.add(table);
            document.close();
            return true;
        } catch (DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
