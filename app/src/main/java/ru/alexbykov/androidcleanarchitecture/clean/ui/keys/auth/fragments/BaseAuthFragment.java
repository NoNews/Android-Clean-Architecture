package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ru.alexbykov.androidcleanarchitecture.R;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.fragments.BaseNetworkFragment;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.views.BaseAuthView;

/**
 * Date: 16.07.2017
 * Time: 17:17
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public abstract class BaseAuthFragment extends BaseNetworkFragment implements BaseAuthView {

    protected EditText etEmail;
    protected EditText etPassword;
    protected Button btnOk;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        etEmail = bindView(R.id.etEmail);
        etPassword = bindView(R.id.etPassword);
        btnOk = bindView(R.id.btnOk);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showPasswordError(boolean show) {
        if (show)
            etPassword.setError(getString(R.string.error_incorrect_password));
        else
            etPassword.setError(null);
    }

    @Override
    public void showEmailError(boolean show) {
        if (show)
            etEmail.setError(getString(R.string.error_incorrect_email));
        else
            etEmail.setError(null);
    }
}
