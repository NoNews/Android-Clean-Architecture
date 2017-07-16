package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.alexbykov.androidcleanarchitecture.clean.data.enity.UserDTO;
import ru.alexbykov.androidcleanarchitecture.clean.data.network.TokenHelper;
import ru.alexbykov.androidcleanarchitecture.clean.domain.auth.AuthInteractor;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.presenters.BasePresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.activities.AuthActivity;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.views.SplashView;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.main_menu.activities.MainActivity;


@InjectViewState
public class SplashPresenter extends BasePresenter<SplashView> implements ModelCallback<UserDTO> {


    private AuthInteractor authInteractor;
    private TokenHelper tokenHelper;

    @Inject
    public SplashPresenter(AuthInteractor authInteractor, TokenHelper tokenHelper) {
        this.authInteractor = authInteractor;
        this.tokenHelper = tokenHelper;
        checkFirstRun(tokenHelper);
    }

    private void checkFirstRun(TokenHelper tokenHelper) {
        if (tokenHelper.isFirstRun()) showAuthActvity();
        else getUser();
    }

    private void getUser() {
        authInteractor.getUser(this);
    }

    @Override
    public void successGetUser(UserDTO user) {
        getViewState().startActivity(MainActivity.class);
    }

    @Override
    public void handleError(String reason) {
        getViewState().showError(reason);
    }

    private void showAuthActvity() {
        getViewState().startActivity(AuthActivity.class);
    }

//    @Override
//    public void showWelcomeActivity() {
//
//    }
}