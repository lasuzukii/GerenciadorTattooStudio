/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author laura
 */
public class Agenda extends javax.swing.JFrame {

    private ArrayList<model.Cliente> clientes;
    private ArrayList<model.Tatuador> tatuadores;
    private ArrayList<model.Agendamento> agendamentos;
    
    public Agenda() {
        initComponents();
        
        this.agendamentos = controller.AgendamentoController.getAgendamentos();
        this.clientes = controller.ClienteController.getClientes();
        this.tatuadores = controller.TatuadorController.getTatuador();
        
        preecherTabela();
        preencheCombos();
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    private void preencheCombos(){
        String[] clientesA = new String[clientes.size()];
        String[] tatuadoresA = new String[tatuadores.size()];
        
        for(int i = 0; i < clientes.size(); i++){
            clientesA[i] = clientes.get(i).getNome();
        }
        
        for(int i = 0; i < tatuadores.size(); i++){
            tatuadoresA[i] = tatuadores.get(i).getNome() + " | R$" + tatuadores.get(i).getValor();
        }
        
        this.jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(clientesA));
        this.jComboBoxTatuador.setModel(new javax.swing.DefaultComboBoxModel<>(tatuadoresA));
    }
    
    private void preecherTabela() {
        String[] colunas = new String[]{"Cliente", "Tatuador", "Data", "Horário", "Duração", "Valor"};
        Object[][] agendamenosT = new Object[this.agendamentos.size()][colunas.length];
        
        for(int i = 0; i < this.agendamentos.size(); i++){
            agendamenosT[i][0] = this.agendamentos.get(i).getCliente().getNome();
            agendamenosT[i][1] = this.agendamentos.get(i).getTatuador().getNome();
            agendamenosT[i][2] = utils.Data.converterDataBr(this.agendamentos.get(i).getData());
            agendamenosT[i][3] = this.agendamentos.get(i).getHora();
            agendamenosT[i][4] = this.agendamentos.get(i).getDuracao();
            agendamenosT[i][5] = this.agendamentos.get(i).getValor();
        }
        
        this.jTableAgenda.setModel(new javax.swing.table.DefaultTableModel(
                agendamenosT,
                colunas
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
    }
    
    private void addElementoTabela(){
        String data = jFormattedTextFieldData.getValue().toString();
        String horario = jFormattedTextFieldHorario.getValue().toString();
        
        String valorTxt = jFormattedTextFieldValor.getValue().toString();
        
        double valor = Double.parseDouble(valorTxt);
        
        this.agendamentos.add(new model.Agendamento(this.clientes.get(jComboBoxCliente.getSelectedIndex()), this.tatuadores.get(jComboBoxTatuador.getSelectedIndex()),
                jTextFieldDuracao.getText(), valor, data, horario, jTextAreaDescricao.getText()));
        
        controller.AgendamentoController.salvarAgendamentos(this.clientes.get(jComboBoxCliente.getSelectedIndex()), this.tatuadores.get(jComboBoxTatuador.getSelectedIndex()), 
                jTextFieldDuracao.getText(), valor, data, horario, jTextAreaDescricao.getText());
        preecherTabela();
        limparCampos();
    }
    
    private void delete() {
        int indexTable = jTableAgenda.getSelectedRow();

        if (indexTable != -1) {
            int option = JOptionPane.showConfirmDialog(this, utils.Constants.MSG_DELETE, "", JOptionPane.YES_NO_OPTION);

            if (option == 0) {
                controller.AgendamentoController.delete(this.agendamentos.get(indexTable));
                this.agendamentos.remove(indexTable);
                preecherTabela();
            }
        } else {
            JOptionPane.showMessageDialog(null, utils.Constants.MSG_SELECIONE_TABELA, "ERRO", JOptionPane.WARNING_MESSAGE);
        }

    }
    
    private void limparCampos(){
        jTextFieldDuracao.setText("");
        jFormattedTextFieldValor.setValue(null);
        jFormattedTextFieldData.setValue("");
        jFormattedTextFieldHorario.setValue("");
        jTextAreaDescricao.setText("");
    }
    
    private void abrirDescricao(){
        int indexTable = jTableAgenda.getSelectedRow();
        
        if(indexTable != -1){
            new TelaDescricao(this.agendamentos.get(indexTable).getDescricao());
        }else{
            JOptionPane.showMessageDialog(null, utils.Constants.MSG_SELECIONE_TABELA, "ERRO", JOptionPane.WARNING_MESSAGE);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCliente = new javax.swing.JLabel();
        jLabelTatuador = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelHorario = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jComboBoxTatuador = new javax.swing.JComboBox<>();
        jLabelDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jButtonAgendar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAgenda = new javax.swing.JTable();
        jLabelDuracao = new javax.swing.JLabel();
        jTextFieldDuracao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jFormattedTextFieldHorario = new javax.swing.JFormattedTextField();
        jFormattedTextFieldValor = new javax.swing.JFormattedTextField();
        jButtonDescricao = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jButtonDeletar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCliente.setBackground(new java.awt.Color(0, 0, 0));
        jLabelCliente.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabelCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCliente.setText("Cliente:");
        getContentPane().add(jLabelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabelTatuador.setBackground(new java.awt.Color(0, 0, 0));
        jLabelTatuador.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabelTatuador.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTatuador.setText("Tatuador:");
        getContentPane().add(jLabelTatuador, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabelValor.setBackground(new java.awt.Color(0, 0, 0));
        jLabelValor.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabelValor.setForeground(new java.awt.Color(255, 255, 255));
        jLabelValor.setText("Valor: R$");
        getContentPane().add(jLabelValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabelData.setBackground(new java.awt.Color(0, 0, 0));
        jLabelData.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabelData.setForeground(new java.awt.Color(255, 255, 255));
        jLabelData.setText("Data:");
        getContentPane().add(jLabelData, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabelHorario.setBackground(new java.awt.Color(0, 0, 0));
        jLabelHorario.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabelHorario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHorario.setText("Horário:");
        getContentPane().add(jLabelHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 20));

        jComboBoxCliente.setBackground(new java.awt.Color(255, 204, 153));
        jComboBoxCliente.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jComboBoxCliente.setMaximumRowCount(100000);
        getContentPane().add(jComboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 210, -1));

        jComboBoxTatuador.setBackground(new java.awt.Color(255, 204, 153));
        jComboBoxTatuador.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        getContentPane().add(jComboBoxTatuador, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 210, -1));

        jLabelDescricao.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabelDescricao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDescricao.setText("Descrição:");
        getContentPane().add(jLabelDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

        jTextAreaDescricao.setBackground(new java.awt.Color(255, 204, 153));
        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 330, 194));

        jButtonAgendar.setBackground(new java.awt.Color(102, 153, 0));
        jButtonAgendar.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jButtonAgendar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgendar.setText("AGENDAR");
        jButtonAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgendarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 204, 153));

        jTableAgenda.setBackground(new java.awt.Color(255, 204, 153));
        jTableAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Tatuador", "Data", "Horário", "Duração", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableAgenda);
        if (jTableAgenda.getColumnModel().getColumnCount() > 0) {
            jTableAgenda.getColumnModel().getColumn(0).setResizable(false);
            jTableAgenda.getColumnModel().getColumn(1).setResizable(false);
            jTableAgenda.getColumnModel().getColumn(2).setResizable(false);
            jTableAgenda.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 700, 230));

        jLabelDuracao.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabelDuracao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDuracao.setText("Duração:");
        getContentPane().add(jLabelDuracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 30));

        jTextFieldDuracao.setBackground(new java.awt.Color(255, 204, 153));
        jTextFieldDuracao.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        getContentPane().add(jTextFieldDuracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 210, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGENDAMENTO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 770, -1));

        jFormattedTextFieldData.setBackground(new java.awt.Color(255, 204, 153));
        try {
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldData.setPreferredSize(new java.awt.Dimension(64, 20));
        getContentPane().add(jFormattedTextFieldData, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 210, 33));

        jFormattedTextFieldHorario.setBackground(new java.awt.Color(255, 204, 153));
        try {
            jFormattedTextFieldHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldHorario.setMinimumSize(new java.awt.Dimension(64, 20));
        jFormattedTextFieldHorario.setPreferredSize(new java.awt.Dimension(126, 20));
        getContentPane().add(jFormattedTextFieldHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 210, 33));

        jFormattedTextFieldValor.setBackground(new java.awt.Color(255, 204, 153));
        jFormattedTextFieldValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        getContentPane().add(jFormattedTextFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 210, 32));

        jButtonDescricao.setBackground(new java.awt.Color(102, 153, 0));
        jButtonDescricao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonDescricao.setText("DESCRIÇÃO");
        jButtonDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDescricaoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 610, -1, -1));

        jButtonFechar.setBackground(new java.awt.Color(102, 153, 0));
        jButtonFechar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonFechar.setText("FECHAR");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, -1, -1));

        jButtonDeletar.setBackground(new java.awt.Color(102, 153, 0));
        jButtonDeletar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonDeletar.setText("DELETAR");
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 610, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/arte2.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgendarActionPerformed
        addElementoTabela();
    }//GEN-LAST:event_jButtonAgendarActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        delete();
    }//GEN-LAST:event_jButtonDeletarActionPerformed

    private void jButtonDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDescricaoActionPerformed
        abrirDescricao();
    }//GEN-LAST:event_jButtonDescricaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgendar;
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonDescricao;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxTatuador;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JFormattedTextField jFormattedTextFieldHorario;
    private javax.swing.JFormattedTextField jFormattedTextFieldValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelDuracao;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelTatuador;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAgenda;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldDuracao;
    // End of variables declaration//GEN-END:variables
}
