package ru.alexbykov.androidcleanarchitecture.clean.ui.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Date: 16.07.2017
 * Time: 18:34
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class MessageUtils {

    public static void showSnackBar(View view, String text) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
    }

}
