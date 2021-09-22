/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.ucb.est;

import java.util.List;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
/**
 *
 * @author PACHECO
 */
public class Bot extends TelegramLongPollingBot{
    Boolean flag=true;
    SendMessage message = new SendMessage();
    Mensaje m=new Mensaje();
    //int n1,n2;
     @Override
    public String getBotToken() {
        return "1962470516:AAEjMe_fFrNiM6Fexf1MBpXngGvxU_OAatM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        int n1 = 0,n2=0;
        System.out.println("Llego mensaje: " + update.toString());
        if (flag==true){
            mensaje_inicial(update);
            flag=false;
        }
        if(update.hasMessage()) { // Verificamos que tenga mensaje
            // Creo el objeto para enviar un mensaje
           
           if (message.getText().equals(m.entrada())){
                message.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
                int opcion = m.opcion_menu(message, update);
                switch (opcion){
                    case 1:
                        message.setText("Ingrese el primer número: ");
                        try {
                            execute(message);
                        } 
                        catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        message.setText("Funcionalidad no implementada. Intente otro día. ");
                        try {
                            execute(message);
                            mensaje_inicial(update);
                        } 
                        catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                            mensaje_inicial(update);
                            break;
                }
            }
            else{
               
                if (message.getText().equals("Ingrese el primer número: ")){
                    if(m.comprobar_numSuma(update.getMessage().getText())==true){
                        //m.setN1(Integer.parseInt(update.getMessage().getText()));
                        n1=Integer.parseInt(update.getMessage().getText());
                        //System.out.println(n1);
                    message.setText("Ingrese el segundo número: ");
                    message.setChatId(update.getMessage().getChatId().toString());
                    try {
                        execute(message);
                    } 
                    catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else
                    mensaje_inicial(update);
            }
                else{
                    if (message.getText().equals("Ingrese el segundo número: ")){
                if(m.comprobar_numSuma(update.getMessage().getText())==true){
                    //m.setN2(Integer.parseInt(update.getMessage().getText()));
                    n2=Integer.parseInt(update.getMessage().getText());
                    //System.out.println(n2);
                    message.setText("La suma es: "+m.suma(n1,n2));
                    message.setChatId(update.getMessage().getChatId().toString());
                    try {
                        execute(message);
                        mensaje_inicial(update);
                    } 
                    catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else
                    mensaje_inicial(update);
            }
            }
        }
    }
}
    public void mensaje_inicial(Update update){
        //Mensaje m=new Mensaje();
        //SendMessage message = new SendMessage();
        message.setText(m.entrada());
        message.setChatId(update.getMessage().getChatId().toString());
        try {
            execute(message);
        } 
        catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "practica_bot";
    }
}
