/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.EventoController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import model.Eventos;
import javax.swing.JOptionPane;

/**
 *
 * @author ghost
 */
public class UpdateDeleteView extends javax.swing.JFrame {
    private String eventImagePath;
    /**
     * Creates new form UpdateDeleteView
     */
    public UpdateDeleteView() {
        initComponents();
        eventImagePath = ""; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEventImg = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        labelData = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        labelLocal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelDescricao = new javax.swing.JTextArea();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        labelSearch = new javax.swing.JTextField();
        labelEventImg1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        labelEventImg.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Upload image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("Hello, Username");

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/ghost/Transferências/trans_bg(2).png")); // NOI18N

        jLabel3.setText("Nome");

        jLabel4.setText("Data");

        jLabel5.setText("Local");

        jLabel6.setText("Descrição");

        labelDescricao.setColumns(20);
        labelDescricao.setRows(5);
        jScrollPane1.setViewportView(labelDescricao);

        btnEdit.setBackground(new java.awt.Color(153, 153, 153));
        btnEdit.setText("Editar Evento");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Deletar Evento");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(153, 153, 153));
        btnSearch.setForeground(new java.awt.Color(204, 255, 255));
        btnSearch.setText("Search Evento");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        labelEventImg1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Upload image");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon("/home/ghost/Transferências/casa.png")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(labelLocal)
                    .addComponent(labelData)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSearch))
                    .addComponent(labelName))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelEventImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLogout))
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch)
                            .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(labelLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelEventImg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Eventos evento = new Eventos();
        // Cria o seletor de arquivos
        JFileChooser chooser = new JFileChooser();
        // Abre a caixa de diálogo e verifica se o usuário aprovou a seleção
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String path = file.getAbsolutePath();
            try {
                // Lê a imagem do arquivo selecionado
                BufferedImage bi = ImageIO.read(file);
                // Redimensiona a imagem (ajuste os valores conforme o desejado para o evento)
                Image img = bi.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                // Cria um ImageIcon com a imagem redimensionada
                ImageIcon icon = new ImageIcon(img);
                // Exibe a imagem no JLabel da interface
                labelEventImg.setIcon(icon);
                // Armazena o caminho da imagem no objeto Evento
                evento.setCaminhoImagem(path);
            } catch (IOException ex) {
                Logger.getLogger(Eventos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Deseja Terminar seção?", "Selecione a Opção", JOptionPane.YES_NO_OPTION);
        if(a == 0){

            setVisible(false);
            new LoginView().setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String idText = labelSearch.getText().trim();
    
    if (idText.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, digite um ID para pesquisa.");
        return;
    }
    
    Long eventId;
    try {
        eventId = Long.parseLong(idText);
    } catch (NumberFormatException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, "ID inválido. Digite um número válido.");
        return;
    }
    
    // Instancia o controller de Evento e busca o evento pelo ID
    EventoController eventoController = new EventoController();
    Eventos evento = eventoController.buscarEvento(eventId);
    
    if (evento == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "Evento não encontrado com o ID: " + eventId);
        return;
    }
    
    // Preenche os campos com os dados do evento
    labelName.setText(evento.getNome());
    
    // Formata a data para exibição (supondo o formato dd/MM/yyyy)
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
    if (evento.getData() != null) {
        labelData.setText(sdf.format(evento.getData()));
    } else {
        labelData.setText("");
    }
    
    labelLocal.setText(evento.getLocal());
    labelDescricao.setText(evento.getDescricao());
    
    // Carrega e exibe a imagem do evento, se houver
    if (evento.getCaminhoImagem() != null && !evento.getCaminhoImagem().isEmpty()) {
        try {
            java.io.File file = new java.io.File(evento.getCaminhoImagem());
            java.awt.image.BufferedImage bi = javax.imageio.ImageIO.read(file);
            // Redimensiona a imagem para o tamanho do label
            java.awt.Image img = bi.getScaledInstance(labelEventImg.getWidth(), labelEventImg.getHeight(), java.awt.Image.SCALE_SMOOTH);
            labelEventImg.setIcon(new javax.swing.ImageIcon(img));
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar a imagem do evento.");
        }
    } else {
        labelEventImg.setIcon(null);
    }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String idText = labelSearch.getText().trim();
    if (idText.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Nenhum evento selecionado para edição.");
        return;
    }
    
    Long eventId;
    try {
        eventId = Long.parseLong(idText);
    } catch (NumberFormatException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, "ID de evento inválido.");
        return;
    }
    
    // Recupera os dados atualizados dos componentes da interface.
    String nome = labelName.getText().trim();
    String dataStr = labelData.getText().trim();  // Ex: "dd/MM/yyyy"
    String local = labelLocal.getText().trim();
    String descricao = labelDescricao.getText().trim();
    
    // Verifica se os campos obrigatórios foram preenchidos.
    if (nome.isEmpty() || dataStr.isEmpty() || local.isEmpty() || descricao.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.");
        return;
    }
    
    // Converte a data de String para java.util.Date.
    java.util.Date dataEvento;
    try {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        dataEvento = sdf.parse(dataStr);
    } catch (java.text.ParseException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, "Data inválida. Por favor, use o formato dd/MM/yyyy.");
        return;
    }
    
    // Recupera o caminho da imagem. 
    // Suponha que a variável de classe "eventImagePath" foi definida no upload da imagem.
    // Caso não tenha sido atualizado, você pode optar por manter o caminho já existente.
    String caminhoImagem = eventImagePath;  
    // Se desejar, verifique se o caminho não está vazio e, caso esteja, exiba uma mensagem ou mantenha o valor anterior.
    
    // Cria um objeto Evento e atribui os valores coletados, inclusive o ID para atualização.
    model.Eventos evento = new model.Eventos();
    evento.setId(eventId);
    evento.setNome(nome);
    evento.setData(dataEvento);
    evento.setLocal(local);
    evento.setDescricao(descricao);
    evento.setCaminhoImagem(caminhoImagem);
    
    // Chama o controller para atualizar o evento.
    EventoController eventoController = new EventoController();
    boolean sucesso = eventoController.salvarEvento(evento);
    
    if (sucesso) {
        javax.swing.JOptionPane.showMessageDialog(this, "Evento atualizado com sucesso!");
        // Opcional: Atualize a lista de eventos na tabela ou redirecione para outra view.
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao atualizar o evento. Verifique os dados e tente novamente.");
    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    setVisible(false);
        DashboardMainView dash = new DashboardMainView();   
    dash.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String idText = labelSearch.getText().trim();
    if (idText.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, digite o ID do evento para deletar.");
        return;
    }
    
    Long eventId;
    try {
        eventId = Long.parseLong(idText);
    } catch (NumberFormatException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, "ID inválido. Por favor, digite um número válido.");
        return;
    }
    
    // 2. Busca o evento utilizando o EventoController
    EventoController eventoController = new EventoController();
    model.Eventos evento = eventoController.buscarEvento(eventId);
    
    if (evento == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "Evento não encontrado com o ID: " + eventId);
        return;
    }
    
    // 3. Preenche os campos da interface com os dados do evento encontrado
    
    // Preenche o nome
    labelName.setText(evento.getNome());
    
    // Preenche a data, formatando-a para "dd/MM/yyyy"
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
    if (evento.getData() != null) {
        labelData.setText(sdf.format(evento.getData()));
    } else {
        labelData.setText("");
    }
    
    // Preenche o local e a descrição
    labelLocal.setText(evento.getLocal());
    labelDescricao.setText(evento.getDescricao());
    
    // Preenche a imagem, se houver
    if (evento.getCaminhoImagem() != null && !evento.getCaminhoImagem().isEmpty()) {
        try {
            java.io.File file = new java.io.File(evento.getCaminhoImagem());
            java.awt.image.BufferedImage bi = javax.imageio.ImageIO.read(file);
            java.awt.Image img = bi.getScaledInstance(labelEventImg.getWidth(), labelEventImg.getHeight(), java.awt.Image.SCALE_SMOOTH);
            labelEventImg.setIcon(new javax.swing.ImageIcon(img));
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar a imagem do evento.");
        }
    } else {
        labelEventImg.setIcon(null);
    }
    
    // 4. Solicita confirmação para exclusão do evento
    int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            "Deseja realmente deletar o evento \"" + evento.getNome() + "\"?",
            "Confirmação de Exclusão", javax.swing.JOptionPane.YES_NO_OPTION);
    
    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        // 5. Chama o método de exclusão no controller
        boolean sucesso = eventoController.removerEvento(eventId);
        if (sucesso) {
            javax.swing.JOptionPane.showMessageDialog(this, "Evento deletado com sucesso!");
            // (Opcional) Limpe os campos e atualize a tabela de eventos, se aplicável.
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao deletar o evento. Tente novamente.");
        }
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateDeleteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDeleteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDeleteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDeleteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDeleteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField labelData;
    private javax.swing.JTextArea labelDescricao;
    private javax.swing.JLabel labelEventImg;
    private javax.swing.JLabel labelEventImg1;
    private javax.swing.JTextField labelLocal;
    private javax.swing.JTextField labelName;
    private javax.swing.JTextField labelSearch;
    // End of variables declaration//GEN-END:variables
}
