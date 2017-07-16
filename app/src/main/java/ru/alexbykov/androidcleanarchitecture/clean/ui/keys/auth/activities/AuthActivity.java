package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.alexbykov.androidcleanarchitecture.R;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.activities.BaseActivity;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.fragments.BaseFragment;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.fragments.RegOrLoginFragment;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters.AuthPresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.views.AuthView;
import ru.alexbykov.androidcleanarchitecture.clean.ui.utils.Navigator;
import ru.alexbykov.androidcleanarchitecture.di.Injector;


public class AuthActivity extends BaseActivity implements AuthView {

    private static final int LAYOUT = R.layout.activity_auth;

    @InjectPresenter
    AuthPresenter authPresenter;
    private TextView tvLogin;
    private TextView tvRegistration;


    @ProvidePresenter
    AuthPresenter provideAuthPresenter() {
        return Injector.getPresenterComponent().getAuthPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(LAYOUT);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setupUI() {
        Navigator.startFragment(RegOrLoginFragment.newInstance(), getSupportFragmentManager(), R.id.ltContainer, false);
    }

    @Override
    public void setupUX() {
        //do notring
    }


    public void showFragment(BaseFragment fragment) {
        Navigator.startFragment(fragment, getSupportFragmentManager(), R.id.ltContainer);
    }
}
