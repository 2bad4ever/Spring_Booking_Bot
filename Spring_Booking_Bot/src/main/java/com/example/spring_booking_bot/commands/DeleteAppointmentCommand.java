package com.example.spring_booking_bot.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class DeleteAppointmentCommand implements WorkerCommand {
    @Override
    public SendMessage start(Update update) {
        // Логика удаления заявки
        return new SendMessage(update.getMessage().getChatId().toString(), "Введите ID заявки для удаления:");
    }

    @Override
    public SendMessage sendDefaultMessage(Update update) {
        return null;
    }
}
