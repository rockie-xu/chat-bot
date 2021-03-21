package dev.rockie.telegrambot.handlers;

public interface Handler<T> {
    void handle(T t);
}
