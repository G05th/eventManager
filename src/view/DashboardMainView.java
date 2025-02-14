/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.EventoController;
import controller.InscricaoController;
import controller.RelatorioController;
import model.EventoTableModel;
import model.Eventos;
import model.Usuario;
import model.UsuarioPapel;
import dao.UsuarioPapelDAO;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import util.Sessao;
import util.UsuarioUtil;

/**
 *
 * @author ghost
 */
public class DashboardMainView extends javax.swing.JFrame {
    
    private Long eventoId;

    /**
     * Creates new form DashboardMainView
     */
    public DashboardMainView() {
        initComponents();
        eventoId = 1L;
        carregarEventos();
        verificarVisibilidadeBtnCriarEvento();
        carregarParticipantes();
        configurarTabela();
    }
    
    private void carregarParticipantes() {
        try {
            InscricaoController inscricaoController = new InscricaoController();
            // Obtém a lista de participantes inscritos para o evento
            List<Usuario> participantes = inscricaoController.listarParticipantesPorEvento(eventoId);
            
            // Cria o modelo de tabela e atribui-o à JTable
            ParticipanteTableModel model = new ParticipanteTableModel(participantes);
            tabelaParticipantes.setModel(model);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar participantes: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void configurarTabela() {
        tabelaParticipantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = tabelaParticipantes.getSelectedRow();
                if (selectedRow >= 0) {
                    ParticipanteTableModel model = (ParticipanteTableModel) tabelaParticipantes.getModel();
                    Usuario participante = model.getParticipanteAt(selectedRow);
                    idParticipante.setText(String.valueOf(participante.getId()));
                    NomeParticipante.setText(participante.getNome());
                    EmailParticipanete.setText(participante.getEmail());
                }
            }
        });
    }
    
   // Dentro da sua view, após carregar o usuário logado e a lista de UsuarioPapel
private void verificarVisibilidadeBtnCriarEvento() {
        Usuario usuarioLogado = Sessao.getUsuarioLogado();
        
        // Se não houver usuário logado, o botão não deve ser visível.
        if (usuarioLogado == null) {
            btnCriarEvento.setVisible(false);
            return;
        }
        
        // Instancia o DAO e busca a lista de associações do usuário
        UsuarioPapelDAO usuarioPapelDAO = new UsuarioPapelDAO();
        try {
            List<UsuarioPapel> listaUsuarioPapel = usuarioPapelDAO.listarPapeisDoUsuario(usuarioLogado.getId());
            
            // Se o usuário possuir ambos os papéis, o botão é visível; caso contrário, fica oculto.
            if (UsuarioUtil.possuiAmbosPapeis(usuarioLogado, listaUsuarioPapel)) {
                btnCriarEvento.setVisible(true);
            } else {
                btnCriarEvento.setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            // Em caso de erro, é seguro ocultar o botão
            btnCriarEvento.setVisible(false);
        }
    }


    
    private void carregarEventos() {
    EventoController eventoController = new EventoController();
    List<Eventos> eventos = null;
    
    // Recupera o usuário logado
    Usuario usuarioLogado = Sessao.getUsuarioLogado();

    if (usuarioLogado != null && possuiPapelOrganizador(usuarioLogado)) {
        eventos = eventoController.listarEventosPorOrganizador(usuarioLogado.getId());
    } else {
        eventos = eventoController.listarEventos();
    }
    
    // Cria o modelo de tabela e atribui à JTable
    EventoTableModel model = new EventoTableModel(eventos);
    TabelaEventos.setModel(model);
}

// Exemplo de método para checar se o usuário tem o papel ORGANIZADOR.
// Essa implementação depende de como você armazenou os papéis do usuário.
private boolean possuiPapelOrganizador(Usuario usuario) {
    // Por exemplo, se o usuário possuir o papel ORGANIZADOR, retorne true.
    // Essa lógica pode buscar na tabela associativa (usuario_papel) ou usar alguma flag no objeto Usuario.
    // Aqui, apenas um exemplo simplificado:
    // Suponha que o usuário tenha um método getPapeis() que retorne uma lista de descrições ou IDs.
    // return usuario.getPapeis().contains("ORGANIZADOR");
    
    // Se não tiver esse método, você pode implementar a verificação através do seu DAO de papéis.
    // Para este exemplo, vamos assumir que o método já retorna true se o usuário for organizador.
    return true; // Altere essa lógica conforme a sua implementação.
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCriarEvento = new javax.swing.JButton();
        btnFormEditORDeleteEvent = new javax.swing.JButton();
        btnRelatório = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaEventos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaParticipantes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        idParticipante = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        NomeParticipante = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        EmailParticipanete = new javax.swing.JTextField();
        cancelarInscriçãoParticipante = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/ghost/Transferências/trans_bg(2).png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("Hello, Username");

        btnCriarEvento.setBackground(new java.awt.Color(153, 153, 153));
        btnCriarEvento.setForeground(new java.awt.Color(204, 255, 255));
        btnCriarEvento.setText("Crate Event");
        btnCriarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarEventoActionPerformed(evt);
            }
        });

        btnFormEditORDeleteEvent.setBackground(new java.awt.Color(255, 51, 51));
        btnFormEditORDeleteEvent.setForeground(new java.awt.Color(204, 255, 255));
        btnFormEditORDeleteEvent.setText("Update / Deletar");
        btnFormEditORDeleteEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormEditORDeleteEventActionPerformed(evt);
            }
        });

        btnRelatório.setBackground(new java.awt.Color(153, 153, 153));
        btnRelatório.setForeground(new java.awt.Color(204, 255, 255));
        btnRelatório.setText("Relatório");
        btnRelatório.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatórioActionPerformed(evt);
            }
        });

        TabelaEventos.setBackground(new java.awt.Color(153, 153, 153));
        TabelaEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data", "Local", "Descrição"
            }
        ));
        jScrollPane1.setViewportView(TabelaEventos);

        jLabel3.setBackground(new java.awt.Color(204, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Eventos");

        tabelaParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Email"
            }
        ));
        jScrollPane2.setViewportView(tabelaParticipantes);

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id");

        idParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idParticipanteActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nome");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");

        cancelarInscriçãoParticipante.setBackground(new java.awt.Color(204, 204, 204));
        cancelarInscriçãoParticipante.setText("Cancelar Inscrição");
        cancelarInscriçãoParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarInscriçãoParticipanteActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon("/home/ghost/Transferências/casa.png")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(idParticipante, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addComponent(NomeParticipante)
                                .addComponent(EmailParticipanete))
                            .addComponent(cancelarInscriçãoParticipante))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnCriarEvento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFormEditORDeleteEvent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRelatório, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(278, 278, 278)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogout)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCriarEvento)
                        .addGap(18, 18, 18)
                        .addComponent(btnFormEditORDeleteEvent)
                        .addGap(18, 18, 18)
                        .addComponent(btnRelatório))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogout)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmailParticipanete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarInscriçãoParticipante)))
                .addGap(197, 197, 197))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idParticipanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idParticipanteActionPerformed

    private void btnRelatórioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatórioActionPerformed
        try {
        // 1. Obtém a lista de eventos através do EventoController
        EventoController eventoController = new EventoController();
        List<Eventos> eventos = eventoController.listarEventos();
        
        if (eventos == null || eventos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum evento encontrado para gerar o relatório.");
            return;
        }
        
        // 2. Abre um JFileChooser para o usuário escolher o local e nome do arquivo PDF
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Salvar Relatório em PDF");
        int userSelection = chooser.showSaveDialog(this);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = chooser.getSelectedFile();
            String caminhoArquivo = fileToSave.getAbsolutePath();
            
            // Garante que o arquivo terá a extensão .pdf
            if (!caminhoArquivo.toLowerCase().endsWith(".pdf")) {
                caminhoArquivo += ".pdf";
            }
            
            // 3. Cria uma instância do RelatorioController e gera o relatório
            RelatorioController relatorioController = new RelatorioController();
            boolean sucesso = relatorioController.gerarRelatorioEventos(eventos, caminhoArquivo);
            
            // 4. Exibe mensagem de sucesso ou erro
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso!\nLocal: " + caminhoArquivo);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gerar o relatório.");
            }
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Ocorreu um erro: " + ex.getMessage());
        ex.printStackTrace();
    }
    }//GEN-LAST:event_btnRelatórioActionPerformed

    private void btnCriarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarEventoActionPerformed
        CreateEventView createEventView = new CreateEventView();
    // Torna a tela visível
    createEventView.setVisible(true);
    }//GEN-LAST:event_btnCriarEventoActionPerformed

    private void btnFormEditORDeleteEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormEditORDeleteEventActionPerformed
        UpdateDeleteView updateDeleteView = new UpdateDeleteView();
    // Torna a tela visível
    updateDeleteView.setVisible(true);
    }//GEN-LAST:event_btnFormEditORDeleteEventActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        setVisible(false);
        PapelView dash = new PapelView();   
    dash.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Deseja Terminar seção?", "Selecione a Opção", JOptionPane.YES_NO_OPTION);
        if(a == 0){

            setVisible(false);
            new LoginView().setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void cancelarInscriçãoParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarInscriçãoParticipanteActionPerformed
        String idStr = idParticipante.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um participante para cancelar a inscrição.");
            return;
        }
        Long participanteId = Long.parseLong(idStr);
        
        try {
            InscricaoController inscricaoController = new InscricaoController();
            boolean sucesso = inscricaoController.removerInscricaoDoEvento(eventoId, participanteId);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Inscrição cancelada com sucesso.");
                carregarParticipantes(); // Atualiza a tabela
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cancelar a inscrição.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cancelarInscriçãoParticipanteActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardMainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmailParticipanete;
    private javax.swing.JTextField NomeParticipante;
    private javax.swing.JTable TabelaEventos;
    private javax.swing.JButton btnCriarEvento;
    private javax.swing.JButton btnFormEditORDeleteEvent;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRelatório;
    private javax.swing.JButton cancelarInscriçãoParticipante;
    private javax.swing.JTextField idParticipante;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaParticipantes;
    // End of variables declaration//GEN-END:variables
}
