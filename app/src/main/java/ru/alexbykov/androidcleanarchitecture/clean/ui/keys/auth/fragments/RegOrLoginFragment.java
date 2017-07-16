package ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.alexbykov.androidcleanarchitecture.R;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.fragments.BaseFragment;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.activities.AuthActivity;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters.RegOrLoginPresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.views.AuthOrAuthView;
import ru.alexbykov.androidcleanarchitecture.di.Injector;


public class RegOrLoginFragment extends BaseFragment implements AuthOrAuthView {

    private static final int LAYOUT = R.layout.fragment_auth_or_auth;

    @InjectPresenter
    RegOrLoginPresenter authOrAuthPresenter;

    private TextView tvLogin;
    private TextView tvRegistration;

    public static RegOrLoginFragment newInstance() {
        RegOrLoginFragment fragment = new RegOrLoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    RegOrLoginPresenter provideAuthOrAuthPresenter() {
        return Injector.getPresenterComponent().getAuthOrAuthPresenter();
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
        tvLogin = bindView(R.id.tvLogin);
        tvRegistration = bindView(R.id.tvRegistration);
    }

    @Override
    public void setupUX() {
        tvLogin.setOnClickListener(v -> ((AuthActivity) getActivity()).showFragment(LoginFragment.newInstance()));
        tvRegistration.setOnClickListener(v -> ((AuthActivity) getActivity()).showFragment(LoginFragment.newInstance()));
    }
}
