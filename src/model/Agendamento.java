package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agendamento {

    private int id;
    private Cliente cliente;
    private Tatuador tatuador;
    private String duracao;
    private double valor;
    private String data;
    private String hora;
    private String descricao;

    public Agendamento(Cliente cliente, Tatuador tatuador, String duracao, double valor, String data, String hora, String descricao) {
        this.id = 0;
        this.cliente = cliente;
        this.tatuador = tatuador;
        this.duracao = duracao;
        this.valor = valor;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
    }
    
    public Agendamento(int id, Cliente cliente, Tatuador tatuador, String duracao, double valor, String data, String hora, String Descricao) {
        this.id = id;
        this.cliente = cliente;
        this.tatuador = tatuador;
        this.duracao = duracao;
        this.valor = valor;
        this.data = data;
        this.hora = hora;
        this.descricao = Descricao;
    }
    
    
    public boolean salvarAgendamento(){
        String script = "INSERT INTO `agendamentos` (`id_cliente`, `id_tatuador`, `duracao`, `valor`, `data_agend`, `hora_agend`,`descricao`) VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement stmt = Banco.getConnection().prepareStatement(script);
            stmt.setInt(1, this.cliente.getId());
            stmt.setInt(2, this.tatuador.getId());
            stmt.setString(3, this.duracao);
            stmt.setDouble(4, this.valor);
            stmt.setString(5, utils.Data.converterDataUs(this.data));
            stmt.setString(6, this.hora);
            stmt.setString(7, this.descricao);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public static ArrayList<Agendamento> getAgendamentos(){
       String query = "SELECT agendamentos.*, clientes.nome AS nome_cliente, clientes.telefone AS telefone_cliente, clientes.data_nascimento AS data_cliente," +
                        "	 tatuadores.nome AS nome_tatuador, tatuadores.valor As valor_tatuador FROM agendamentos" +
                        "        INNER JOIN clientes ON agendamentos.id_cliente = clientes.id" +
                        "        INNER JOIN tatuadores ON agendamentos.id_tatuador = tatuadores.id;";
       
       try {
            PreparedStatement stmt = Banco.getConnection().prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            
            
            ArrayList<Agendamento> agendamentos = new ArrayList();
            while(results.next()){
                Cliente cliente = new Cliente(results.getInt("id_cliente"), results.getString("nome_cliente"), results.getString("telefone_cliente"), results.getString("data_cliente"));
                Tatuador tatuador = new Tatuador(results.getInt("id_tatuador"), results.getString("nome_tatuador"), results.getDouble("valor_tatuador"));
                
                agendamentos.add(new Agendamento(results.getInt("id"), cliente, tatuador, results.getString("duracao"), results.getDouble("valor"),
                        results.getString("data_agend"), results.getString("hora_agend"), results.getString("descricao")));
            }
            
            return agendamentos;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean deletar(){
        String script = "DELETE FROM agendamentos WHERE `id` = ?;";
        
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

    public Cliente getCliente() {
        return cliente;
    }

    public Tatuador getTatuador() {
        return tatuador;
    }

    public String getDuracao() {
        return duracao;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getHora() {
        return hora;
    }

    

}
