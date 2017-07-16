package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.main_menu.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.alexbykov.androidcleanarchitecture.clean.ui.base.presenters.BasePresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.main_menu.interfaces.views.MainView;


@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    public MainPresenter() {

    }

}