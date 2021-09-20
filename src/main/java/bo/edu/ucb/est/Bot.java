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
     @Override
    public String getBotToken() {
        return "1962470516:AAEjMe_fFrNiM6Fexf1MBpXngGvxU_OAatM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("Llego mensaje: " + update.toString());
        if(update.hasMessage()) { // Verificamos que tenga mensaje
            // Creo el objeto para enviar un mensaje
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
            message.setText("Hello " + update.getMessage().getFrom().getFirstName());
            try {
                execute(message); // Envia el mensaje
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "practica_bot";
    }
}
