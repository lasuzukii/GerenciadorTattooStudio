package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;

public class Cliente {

    private int id;
    private String nome;
    private String telefone;
    private String dataNascimento;
    
    public Cliente(String nome, String telefone, String dataNascimento) {
        this.id = 0;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        

    }
    
    public Cliente(int id, String nome, String telefone, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        

    }
    
    public boolean salvarCliente(){
        String script = "INSERT INTO `clientes` (`nome`, `telefone`, `data_nascimento`) VALUES (?, ?, ?);";
        
        Connection connection = Banco.getConnection();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(script);
            stmt.setString(1, this.nome);
            stmt.setString(2, this.telefone);
            stmt.setString(3, utils.Data.converterDataUs(this.dataNascimento));
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    public static ArrayList<Cliente> getClientes(){
       String query = "SELECT * FROM `clientes`";
       
       try {
            PreparedStatement stmt = Banco.getConnection().prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            
            
            ArrayList<Cliente> clientes = new ArrayList();
            while(results.next()){
                clientes.add(new Cliente(results.getInt("id"),results.getString("nome"),results.getString("telefone"),results.getString("data_nascimento")));
            }
            
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void deletar() throws SQLException {
       // try {
            String script = "DELETE FROM clientes WHERE `id` = ?;";
            
            
            PreparedStatement stmt = Banco.getConnection().prepareStatement(script);
            stmt.setInt(1, this.id);
            stmt.executeUpdate();
            //return true;
            
        /*} catch (SQLIntegrityConstraintViolationException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
       // return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }
}
