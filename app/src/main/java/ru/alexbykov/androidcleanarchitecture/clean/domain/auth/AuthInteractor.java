package ru.alexbykov.androidcleanarchitecture.clean.domain.auth;

import ru.alexbykov.androidcleanarchitecture.clean.data.repository.auth.AuthRepository;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters.ModelCallback;

/**
 * Date: 15.07.2017
 * Time: 22:58
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class AuthInteractor {


    private AuthRepository authRepository;


    public AuthInteractor(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void loginUser(ModelCallback userCallback, String email, String password) {
        authRepository.loginUser(userCallback, email, password);
    }

    public void regUser(ModelCallback userCallback, String email, String password) {
        authRepository.regUser(userCallback, email, password);
    }

    public void getUser(ModelCallback userCallback) {
        authRepository.getUser(userCallback);
    }
}
