package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.alexbykov.androidcleanarchitecture.clean.data.enity.UserDTO;
import ru.alexbykov.androidcleanarchitecture.clean.domain.auth.AuthInteractor;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.presenters.BasePresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.views.BaseAuthView;
import ru.alexbykov.androidcleanarchitecture.clean.ui.utils.DataChecker;


@InjectViewState
public class LoginPresenter extends BasePresenter<BaseAuthView> implements ModelCallback<UserDTO> {

    private AuthInteractor authInteractor;

    private String password;
    private String email;

    @Inject
    LoginPresenter(AuthInteractor authInteractor) {
        this.authInteractor = authInteractor;
    }

    public void loginUser(String email, String password) {
        this.email = email;
        this.password = password;
        hideErrors();
        if (isCorrect()) login();
        else showErrors();
    }

    private void login() {
        getViewState().hideKeyboard();
        showProgress();
        authInteractor.loginUser(this, email, password);
    }


    private void hideErrors() {
        getViewState().showPasswordError(false);
        getViewState().showEmailError(false);
    }

    private void showErrors() {
        if (!DataChecker.isCorrectEmail(email)) getViewState().showEmailError(true);
        if (!DataChecker.isCorrectPasswordLength(password)) getViewState().showPasswordError(true);
    }


    private boolean isCorrect() {
        return DataChecker.isCorrectEmail(email) && DataChecker.isCorrectPasswordLength(password);
    }

    @Override
    public void successGetUser(UserDTO user) {
        hideProgress();
    }


    private void showProgress() {
        getViewState().showData(false);
        getViewState().showProgress(true);
    }


    private void hideProgress() {
        getViewState().showData(true);
        getViewState().showProgress(false);
    }

    @Override
    public void handleError(String reason) {
        hideProgress();
        getViewState().showError(reason);
    }
}
