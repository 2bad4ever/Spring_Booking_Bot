package com.example.spring_booking_bot;
import com.example.spring_booking_bot.commands.AddAppointmentCommand;
import com.example.spring_booking_bot.commands.DeleteAppointmentCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import com.example.spring_booking_bot.commands.AddAppointmentCommand;
import com.example.spring_booking_bot.commands.DeleteAppointmentCommand;
import com.example.spring_booking_bot.commands.LoginCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    private LoginCommand loginCommand;

    @Override
    public String getBotUsername() {
        return "superldfkdlfk_bot";
    }

    @Autowired
    private AddAppointmentCommand addAppointmentCommand;

    @Autowired
    private DeleteAppointmentCommand deleteAppointmentCommand;

    @Override
    public String getBotToken() {
        return "6619638884:AAH4k0oh5GVkL6jK1zZYFyvDKNEpqxeoa90";
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage responseMessage = null;
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            switch (messageText) {
                case "/addappointment":
                    responseMessage = addAppointmentCommand.start(update);
                    break;
                case "/deleteappointment":
                    responseMessage = deleteAppointmentCommand.start(update);
                    break;
                // Добавьте кейсы для ChooseTimeCommand и ChooseDoctorCommand
                default:
                    responseMessage = new SendMessage(update.getMessage().getChatId().toString(), "Неизвестная команда");
                    break;
            }


        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

// Аналогично для ChooseTimeCommand и ChooseDoctorCommand


        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("Записаться к врачу"));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setResizeKeyboard(true); // Опционально: сделать клавиатуру автоматически масштабируемой
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }
}

