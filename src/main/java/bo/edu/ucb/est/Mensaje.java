/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.ucb.est;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author PACHECO
 */
public class Mensaje {
    //int n1,n2;

    /*public void setN1(int n1) {
        this.n1 = n1;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }
    private String mensaje;

    public Mensaje(){
        
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }*/
    
    public String entrada(){
        //SendMessage message = new SendMessage();
        String ms = null;  
            try {
                ms=("Bienvenido al Bot Calculadora.\n" + "Seleccione una de las siguientes opciones:\n"+
                "1. Sumar dos números.\n"+"2. Calcular serie de fibonacci.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return ms;
    }
    public int opcion_menu(SendMessage Message, Update update){
        int opcion=0;
        try {
            opcion = Integer.parseInt(update.getMessage().getText());
        }
        catch (NumberFormatException e){
            opcion = 0;
        }
        return opcion;
    }
    
    
    public int suma(int n1,int n2){
        int suma=0;
        suma=n1+n2;
        return suma;
    }
    public boolean comprobar_numSuma(String mensaje){
        int n;
        try{
           n = Integer.parseInt(mensaje);
           //System.out.println(n);
           return true;
           
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
