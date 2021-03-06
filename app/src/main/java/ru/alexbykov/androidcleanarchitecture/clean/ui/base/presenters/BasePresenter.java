package ru.alexbykov.androidcleanarchitecture.clean.ui.base.presenters;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * Created by Alex Bykov on 15.02.2017.
 * You can contact me at: me@alexbykov.ru.
 */

public abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    protected final String TAG = getClass().getSimpleName();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected final void unSubscribeOnDestroy(@NonNull Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
