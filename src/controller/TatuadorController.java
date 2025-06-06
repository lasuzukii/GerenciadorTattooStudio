
package controller;

import java.sql.SQLException;
import java.util.ArrayList;

public class TatuadorController {
    public static boolean salvarCliente(String nome, double valor) throws IllegalArgumentException{
        if(nome.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        
        model.Tatuador tatuador = new model.Tatuador(nome, valor);
        return tatuador.salvarTatuador();
    }
    
    public static ArrayList<model.Tatuador> getTatuador(){
        return model.Tatuador.getClientes();
    }
    
    public static void delete(model.Tatuador tatuador) throws SQLException{
        tatuador.deletar();
    }
}
