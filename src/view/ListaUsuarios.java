/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ListaUsuarios extends javax.swing.JDialog {

    private ArrayList<model.Usuario> usuarios;
    private java.awt.Frame parent;
    private model.Usuario usuario;
    
    public ListaUsuarios(java.awt.Frame parent, boolean modal, model.Usuario usuario) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        
        this.usuario = usuario;
        
        this.usuarios = controller.UsuarioController.getUsuarios();
        preecherTabela();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void preecherTabela() {
        String[] colunas = new String[]{ "ID", "USUÁRIO", "TIPO"};
        Object[][] agendamenosT = new Object[this.usuarios.size()][colunas.length];
        
        for(int i = 0; i < this.usuarios.size(); i++){
            agendamenosT[i][0] = this.usuarios.get(i).getId();
            agendamenosT[i][1] = this.usuarios.get(i).getNomeUsuario();
            agendamenosT[i][2] = this.usuarios.get(i).getTipo();
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
            if (this.usuario.getId() != this.usuarios.get(indexTable).getId()) {
                int option = JOptionPane.showConfirmDialog(this, utils.Constants.MSG_DELETE, "", JOptionPane.YES_NO_OPTION);

                if (option == 0) {
                    controller.UsuarioController.delete(this.usuarios.get(indexTable));
                    this.usuarios.remove(indexTable);
                    preecherTabela();
                }
            }else{
                JOptionPane.showMessageDialog(null, utils.Constants.MSG_NAO_USUARIO, "ERRO", JOptionPane.WARNING_MESSAGE);
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
        jLabel1.setText("LISTA DE USUÁRIO");

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "USUÁRIO", "TIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        new CadastroUsuarios(this.parent,true);
        this.usuarios = controller.UsuarioController.getUsuarios();
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
