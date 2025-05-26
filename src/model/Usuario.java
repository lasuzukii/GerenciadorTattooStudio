package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {
    
    private int id;
    private String nomeUsuario;
    private String senha;
    private char tipo;

    public Usuario(int id, String nomeUsuario, String senha, char tipo) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipo = tipo;
    }
    
    public Usuario(String nomeUsuario, String senha, char tipo) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipo = tipo;
    }
    
    public boolean salvarUsuario(){
        String script = "INSERT INTO `usuarios` (`nome`, `senha`, `TIPO`) VALUES (?, ?, ?);";
        
        Connection connection = Banco.getConnection();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(script);
            stmt.setString(1, this.nomeUsuario);
            stmt.setString(2, this.senha);
            stmt.setString(3, this.tipo+"");
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    public static Usuario logar(String usuarioLog, String senhaLog){
        String query = "SELECT * FROM `usuarios` WHERE nome = ? AND senha = ?;";
        Usuario usuario = null;
        
        try {
            PreparedStatement stmt = Banco.getConnection().prepareStatement(query);
            stmt.setString(1, usuarioLog);
            stmt.setString(2, senhaLog);
            
            ResultSet resultSet = stmt.executeQuery();
            
            while(resultSet.next()){
                usuario = new Usuario(resultSet.getInt("id"),resultSet.getString(utils.Constants.TAB_USUARIO_NOME),resultSet.getString(utils.Constants.TAB_USUARIO_SENHA), resultSet.getString(utils.Constants.TAB_USUARIO_TIPO).charAt(0));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }
    
    public static ArrayList<Usuario> getUsuarios(){
       String query = "SELECT * FROM `usuarios`";
       
       try {
            PreparedStatement stmt = Banco.getConnection().prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            
            
            ArrayList<Usuario> usuarios = new ArrayList();
            while(results.next()){
                usuarios.add(new Usuario(results.getInt("id"), results.getString("nome"), results.getString("senha"), results.getString("tipo").charAt(0)));
            }
            
            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean deletar(){
        String script = "DELETE FROM usuarios WHERE `id` = ?;";
        
        try {
            PreparedStatement stmt = Banco.getConnection().prepareStatement(script);
            stmt.setInt(1, this.id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public int getId() {
        return id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public char getTipo() {
        return tipo;
    }
}
