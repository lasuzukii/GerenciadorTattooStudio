package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tatuador {

    private int id;
    private String nome;
    private double valor;
    
    public Tatuador(String nome, double valor) {
        this.id = 0;
        this.nome = nome;
        this.valor = valor;
    }
    
    public Tatuador(int id,String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }
    
    public boolean salvarTatuador(){
        String script = "INSERT INTO `tatuadores` (`nome`, `valor`) VALUES (?, ?);";
        
        Connection connection = Banco.getConnection();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(script);
            stmt.setString(1, this.nome);
            stmt.setDouble(2, this.valor);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    public static ArrayList<Tatuador> getClientes(){
       String query = "SELECT * FROM `tatuadores`";
       
       try {
            PreparedStatement stmt = Banco.getConnection().prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            
            
            ArrayList<Tatuador> tatuadores = new ArrayList();
            while(results.next()){
                tatuadores.add(new Tatuador(results.getInt("id"),results.getString("nome"),results.getDouble("valor")));
            }
            
            return tatuadores;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void deletar() throws SQLException {
        String script = "DELETE FROM tatuadores WHERE `id` = ?;";

        PreparedStatement stmt = Banco.getConnection().prepareStatement(script);
        stmt.setInt(1, this.id);
        stmt.executeUpdate();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValorSessao(double valorSessao) {
        this.valor = valorSessao;
    }

    public int getId() {
        return id;
    }
    
}
