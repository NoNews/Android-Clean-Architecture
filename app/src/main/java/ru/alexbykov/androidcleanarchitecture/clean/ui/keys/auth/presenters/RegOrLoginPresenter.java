package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.alexbykov.androidcleanarchitecture.clean.ui.base.presenters.BasePresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.views.AuthOrAuthView;


@InjectViewState
public class RegOrLoginPresenter extends BasePresenter<AuthOrAuthView> {

    @Inject
    public RegOrLoginPresenter() {

    }

}
