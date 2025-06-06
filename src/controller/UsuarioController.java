
package controller;

import java.util.ArrayList;

public class UsuarioController {
    public static model.Usuario logar(String usuarioText, String senhaText) throws IllegalArgumentException{
        if(usuarioText.trim().isEmpty() && senhaText.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        return model.Usuario.logar(usuarioText, senhaText);
    }
    
    public static boolean salvarUsuario(String nome, String senha, char tipo) throws IllegalArgumentException{
        if(nome.trim().isEmpty() && senha.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        
        model.Usuario tatuador = new model.Usuario(nome, senha,tipo);
        return tatuador.salvarUsuario();
    }
    
    public static ArrayList<model.Usuario> getUsuarios(){
        return model.Usuario.getUsuarios();
    }
    
    public static boolean delete(model.Usuario usuario){
        return usuario.deletar();
    }
}
