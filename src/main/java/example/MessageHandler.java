package example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class MessageHandler extends Thread {
    private Update update;
    private String text;
    private String reply = "";
    private Bot bot;

    public MessageHandler(Update update, Bot bot){
        this.update = update;
        text = update.getMessage().getText();
        this. bot = bot;
    }

    @Override
    public void run(){
        switch (text){
            case "1" : reply = "В три 15:30, Матеша"; break;
            default:reply = "Я не понимаю";
        }
        SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(reply);
        try {
            bot.execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
