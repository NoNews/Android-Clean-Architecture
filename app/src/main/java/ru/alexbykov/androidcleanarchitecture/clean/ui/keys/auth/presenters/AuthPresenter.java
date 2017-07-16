package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.views.AuthView;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.presenters.BasePresenter;


@InjectViewState
public class AuthPresenter extends BasePresenter<AuthView> {

    @Inject
    public AuthPresenter() {

    }

}