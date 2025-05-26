/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;

public class AgendamentoController {
    public static boolean salvarAgendamentos(model.Cliente cliente, model.Tatuador tatuador, String duracao, double valor, String data, String hora, String descricao) throws IllegalArgumentException{
        if(duracao.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        
        model.Agendamento agendamento = new model.Agendamento(cliente, tatuador, duracao, valor, data, hora, descricao);
        return agendamento.salvarAgendamento();
    }
    
    public static ArrayList<model.Agendamento> getAgendamentos(){
        return model.Agendamento.getAgendamentos();
    }
    
    public static boolean delete(model.Agendamento agendamento){
        return agendamento.deletar();
    }
}
