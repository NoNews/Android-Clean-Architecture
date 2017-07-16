package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.activities;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.alexbykov.androidcleanarchitecture.R;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.activities.BaseActivity;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters.SplashPresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.views.SplashView;
import ru.alexbykov.androidcleanarchitecture.di.Injector;


public class SplashActivity extends BaseActivity implements SplashView {

    private static final int LAYOUT = R.layout.activity_splash;

    @InjectPresenter
    SplashPresenter splashPresenter;

    @ProvidePresenter
    SplashPresenter provideSplashPresenter() {
        return Injector.getPresenterComponent().getSplashPresenter();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void setupUI() {

    }

    @Override
    public void setupUX() {

    }
}
