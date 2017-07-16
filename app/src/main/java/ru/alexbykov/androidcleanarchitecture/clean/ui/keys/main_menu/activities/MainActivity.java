package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.main_menu.activities;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.alexbykov.androidcleanarchitecture.R;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.activities.BaseActivity;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.main_menu.interfaces.views.MainView;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.main_menu.presenters.MainPresenter;
import ru.alexbykov.androidcleanarchitecture.di.Injector;


public class MainActivity extends BaseActivity implements MainView {

    private static final int LAYOUT = R.layout.activity_main2;

    @InjectPresenter
    MainPresenter mainPresenter;


    @ProvidePresenter
    MainPresenter provideMainPresenter() {
        return Injector.getPresenterComponent().getMainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
    }

    @Override
    public void setupUI() {

    }

    @Override
    public void setupUX() {

    }
}
