/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rone01
 */
public class Data {
    public static String converterDataUs(String dataString){
        String formatoEntrada = "dd/MM/yyyy";
        String formatoSaida = "yyyy-MM-dd";

        SimpleDateFormat formatoEntradaObj = new SimpleDateFormat(formatoEntrada);
        SimpleDateFormat formatoSaidaObj = new SimpleDateFormat(formatoSaida);

        try {
            Date data = formatoEntradaObj.parse(dataString);

            String dataFormatada = formatoSaidaObj.format(data);

            return dataFormatada;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static String converterDataBr(String dataString){
        String formatoEntrada = "yyyy-MM-dd";
        String formatoSaida = "dd/MM/yyyy";
        

        SimpleDateFormat formatoEntradaObj = new SimpleDateFormat(formatoEntrada);
        SimpleDateFormat formatoSaidaObj = new SimpleDateFormat(formatoSaida);

        try {
            Date data = formatoEntradaObj.parse(dataString);

            String dataFormatada = formatoSaidaObj.format(data);

            return dataFormatada;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
