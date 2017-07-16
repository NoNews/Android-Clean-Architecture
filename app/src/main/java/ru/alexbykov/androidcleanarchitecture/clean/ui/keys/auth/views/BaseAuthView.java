package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.views;


import ru.alexbykov.androidcleanarchitecture.clean.ui.base.views.NetworkView;

public interface BaseAuthView extends NetworkView {
    void showPasswordError(boolean show);
    void showEmailError(boolean show);
    void showError(String error);
    void hideKeyboard();
}
