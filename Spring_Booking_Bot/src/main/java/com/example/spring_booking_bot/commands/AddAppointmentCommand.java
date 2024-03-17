package com.example.spring_booking_bot.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class AddAppointmentCommand implements WorkerCommand {
    @Override
    public SendMessage start(Update update) {
        // Логика добавления заявки
        return new SendMessage(update.getMessage().getChatId().toString(), "Выберите врача:");
    }

    @Override
    public SendMessage sendDefaultMessage(Update update) {
        // Логика по умолчанию (если нужна)
        return null;
    }
}
