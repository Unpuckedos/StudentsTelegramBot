package example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            MessageHandler message = new MessageHandler(update, this);
            message.run();
        }
    }

    @Override
    public String getBotUsername() {
        return "StudBot";
    }

    @Override
    public String getBotToken() {
        return "612511178:AAGoHruw73UrgLwqjKlDQ8jIQ1E2t27LOKk";
    }
}
