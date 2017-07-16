package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.alexbykov.androidcleanarchitecture.R;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters.LoginPresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.views.BaseAuthView;
import ru.alexbykov.androidcleanarchitecture.clean.ui.utils.MessageUtils;
import ru.alexbykov.androidcleanarchitecture.di.Injector;


public class LoginFragment extends BaseAuthFragment implements BaseAuthView {

    private static final int LAYOUT = R.layout.fragment_login_and_reg;

    @InjectPresenter
    LoginPresenter loginPresenter;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    LoginPresenter provideLoginPresenter() {
        return Injector.getPresenterComponent().getLoginPresenter();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        rootView = inflater.inflate(LAYOUT, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }

    @Override
    public void setupUI() {
        btnOk.setText(bindString(R.string.auth_login));
    }

    @Override
    public void setupUX() {
        btnOk.setOnClickListener(v -> loginPresenter.loginUser(etEmail.getText().toString(), etPassword.getText().toString()));
    }

    @Override
    public void showError(String error) {
        MessageUtils.showSnackBar(ltData, error);
    }
}
