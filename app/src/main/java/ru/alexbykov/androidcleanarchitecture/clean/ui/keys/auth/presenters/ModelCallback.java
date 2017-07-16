package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters;

/**
 * Date: 16.07.2017
 * Time: 14:50
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public interface ModelCallback<T> {

    void successGetUser(T t);
    void handleError(String reason);

}
