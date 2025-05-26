/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

/**
 *
 * @author Rone01
 */
public class ClienteController {
    public static boolean salvarCliente(String nome, String telefone, String data) throws IllegalArgumentException{
        if(nome.trim().isEmpty() && telefone.trim().isEmpty() && data.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        
        model.Cliente cliente = new model.Cliente(nome, telefone, data);
        return cliente.salvarCliente();
    }
    
    public static ArrayList<model.Cliente> getClientes(){
        return model.Cliente.getClientes();
    }
    
    public static void delete(model.Cliente cliente) throws SQLException {
         cliente.deletar();
    }
}
