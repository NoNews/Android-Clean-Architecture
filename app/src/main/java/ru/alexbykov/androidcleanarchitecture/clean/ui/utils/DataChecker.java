package ru.alexbykov.androidcleanarchitecture.clean.ui.utils;

/**
 * Date: 16.07.2017
 * Time: 17:33
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class DataChecker {


    private static final int MIN_PASSWORD_LENGTH = 6;


    public static boolean isCorrectEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isCorrectPasswordLength(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }
}
