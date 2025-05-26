package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/**
 *
 * @author laura
 */
public class Menu extends javax.swing.JFrame {

    private model.Usuario usuario;
    
    public Menu(model.Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        setTitle("TATTOO STUDIO");
        
        verificarPermissoes();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void verificarPermissoes(){
        if(this.usuario.getTipo() == utils.Constants.TIPO_USUARIO_COMUM){
            jMenuItemUsuarios.setEnabled(false);
            jMenuItemLisUsuario.setEnabled(false);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItemTatuador = new javax.swing.JMenuItem();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuOperação = new javax.swing.JMenu();
        jMenuItemAgendar = new javax.swing.JMenuItem();
        jMenuListas = new javax.swing.JMenu();
        jMenuItemLisCliente = new javax.swing.JMenuItem();
        jMenuItemListatuadores = new javax.swing.JMenuItem();
        jMenuItemLisUsuario = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Pristina", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tattoo Studio");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 170, 829, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/arte2.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 470));

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenuCadastro.setBackground(new java.awt.Color(51, 0, 255));
        jMenuCadastro.setForeground(new java.awt.Color(0, 0, 0));
        jMenuCadastro.setText("Cadastro");

        jMenuItemCliente.setText("Cliente");
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCliente);

        jMenuItemTatuador.setText("Tatuador");
        jMenuItemTatuador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTatuadorActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemTatuador);

        jMenuItemUsuarios.setText("Usurários");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemUsuarios);

        jMenuBar1.add(jMenuCadastro);

        jMenuOperação.setText("Operação");

        jMenuItemAgendar.setText("Agendar");
        jMenuItemAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgendarActionPerformed(evt);
            }
        });
        jMenuOperação.add(jMenuItemAgendar);

        jMenuBar1.add(jMenuOperação);

        jMenuListas.setText("Listas");

        jMenuItemLisCliente.setText("Clientes");
        jMenuItemLisCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLisClienteActionPerformed(evt);
            }
        });
        jMenuListas.add(jMenuItemLisCliente);

        jMenuItemListatuadores.setText("Tatuadores");
        jMenuItemListatuadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListatuadoresActionPerformed(evt);
            }
        });
        jMenuListas.add(jMenuItemListatuadores);

        jMenuItemLisUsuario.setText("Usuários");
        jMenuItemLisUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLisUsuarioActionPerformed(evt);
            }
        });
        jMenuListas.add(jMenuItemLisUsuario);

        jMenuBar1.add(jMenuListas);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        new CadastroCliente(this,true);
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void jMenuItemTatuadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTatuadorActionPerformed
        new CadastroTatuador(this,true);
    }//GEN-LAST:event_jMenuItemTatuadorActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        new CadastroUsuarios(this, true);
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void jMenuItemAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgendarActionPerformed
        new Agenda();
    }//GEN-LAST:event_jMenuItemAgendarActionPerformed

    private void jMenuItemLisClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLisClienteActionPerformed
        new ListaClientes(this, true);
    }//GEN-LAST:event_jMenuItemLisClienteActionPerformed

    private void jMenuItemListatuadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListatuadoresActionPerformed
        new ListaTatuadores(this, true);
    }//GEN-LAST:event_jMenuItemListatuadoresActionPerformed

    private void jMenuItemLisUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLisUsuarioActionPerformed
        new ListaUsuarios(this, true, this.usuario);
    }//GEN-LAST:event_jMenuItemLisUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuItemAgendar;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemLisCliente;
    private javax.swing.JMenuItem jMenuItemLisUsuario;
    private javax.swing.JMenuItem jMenuItemListatuadores;
    private javax.swing.JMenuItem jMenuItemTatuador;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenu jMenuListas;
    private javax.swing.JMenu jMenuOperação;
    // End of variables declaration//GEN-END:variables
}
