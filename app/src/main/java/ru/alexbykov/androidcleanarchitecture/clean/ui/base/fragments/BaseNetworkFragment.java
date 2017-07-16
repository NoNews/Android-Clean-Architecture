package ru.alexbykov.androidcleanarchitecture.clean.ui.base.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ru.alexbykov.androidcleanarchitecture.R;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.views.NetworkView;

/**
 * Date: 16.07.2017
 * Time: 17:25
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public abstract class BaseNetworkFragment extends BaseFragment implements NetworkView {


    protected ViewGroup ltData;
    private ProgressBar progressBar;
    private Button btnRepeat;
    private ViewGroup ltError;
    private TextView tvError;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ltData = bindView(R.id.ltData);
        progressBar = bindView(R.id.progressBar);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showProgress(boolean show) {
        if (show) showView(progressBar);
        else hideView(progressBar);
    }

    @Override
    public void showData(boolean show) {
        if (show) showView(ltData);
        else hideView(ltData);
    }

    @Override
    public void showError(boolean show, String text) {
        if (show) {
            showView(ltError);
            tvError.setText(text);
        } else hideView(ltError);
    }


}
