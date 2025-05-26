/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ListaClientes extends javax.swing.JDialog {

    private ArrayList<model.Cliente> clientes;
    private java.awt.Frame parent;
    
    public ListaClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        
        this.clientes = controller.ClienteController.getClientes();
        preecherTabela();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void preecherTabela() {
        String[] colunas = new String[]{"ID", "NOME", "TELEFONE", "DATA NASC"};
        Object[][] agendamenosT = new Object[this.clientes.size()][colunas.length];
        
        for(int i = 0; i < this.clientes.size(); i++){
            agendamenosT[i][0] = this.clientes.get(i).getId();
            agendamenosT[i][1] = this.clientes.get(i).getNome();
            agendamenosT[i][2] = this.clientes.get(i).getTelefone();
            agendamenosT[i][3] = utils.Data.converterDataBr(this.clientes.get(i).getDataNascimento());
        }
        
        this.jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
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
    
    private void delete() {
        int indexTable = jTableClientes.getSelectedRow();

        if (indexTable != -1) {
            int option = JOptionPane.showConfirmDialog(this, utils.Constants.MSG_DELETE, "", JOptionPane.YES_NO_OPTION);

            if (option == 0) {
                try {
                    controller.ClienteController.delete(this.clientes.get(indexTable));
                    this.clientes.remove(indexTable);
                    preecherTabela();
                } catch (SQLIntegrityConstraintViolationException ex) {
                    Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, utils.Constants.MSG_ERRO_DELETE, "ERRO", JOptionPane.WARNING_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, utils.Constants.MSG_SELECIONE_TABELA, "ERRO", JOptionPane.WARNING_MESSAGE);
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jButtonDelete = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA DE CLIENTES");

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "TELEFONE", "DATA NASC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jButtonDelete.setBackground(new java.awt.Color(153, 255, 153));
        jButtonDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonDelete.setText("DELETE");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonFechar.setBackground(new java.awt.Color(153, 255, 153));
        jButtonFechar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonFechar.setText("FECHAR");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButtonAdicionar.setBackground(new java.awt.Color(153, 255, 153));
        jButtonAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAdicionar.setText("ADICIONAR");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDelete)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAdicionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonFechar)
                    .addComponent(jButtonAdicionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        delete();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        new CadastroCliente(this.parent,true);
        this.clientes = controller.ClienteController.getClientes();
        preecherTabela();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    // End of variables declaration//GEN-END:variables
}
