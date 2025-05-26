/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


public class Constants {
    public static final String URL = "jdbc:mysql://localhost:3306/tattoo_db";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    
    public static final String MSG_DRIVE = "dRIVE NÃO LOCALIZADO";
    public static final String MSG_BANCO_CONECTION = "FALHA AO CONECTAR AO BANCO";
    public static final String MSG_USUARIO_INEXISTENTE = "USUARIO INVÁLIDO";
    public static final String MSG_CAMPOS_VAZIOS = "PREENCHA OS CAMPOS OBRIGATÓRIOS";
    public static final String MSG_VALOR_INVALIDO = "VALOR INVÁLIDO";
    public static final String MSG_NAO_USUARIO = "VOCÊ NÃO PODE DELETAR SEU PROPRIO USUÁRIO";
    
    public static final String MSG_ERRO_SALVA_CLIENTE = "ERRO AO SALVAR O CLIENTE";
    public static final String MSG_SUCESSO = "SUCESSO";
    
    public static final String TAB_USUARIO_NOME = "nome";
    public static final String TAB_USUARIO_SENHA = "senha";
    public static final String TAB_USUARIO_TIPO = "tipo";
    
    public static final char TIPO_USUARIO_MASTER = 'M';
    public static final char TIPO_USUARIO_COMUM = 'C';
    
    public static final String MSG_SELECIONE_TABELA = "SELECIONE UM AGENDAMENTO";
    public static final String MSG_ERRO_DELETE = "NÃO É PERMITIDO DELETAR UM REGISTRO QUE ESTÁ SENDO USADO NOS AGENDAMENTOS";
    public static final String MSG_DELETE = "TEM CERTEZA?";
    
    public static final String FORMATO_DATA_BANCO = "yyyy-MM-dd";
}
