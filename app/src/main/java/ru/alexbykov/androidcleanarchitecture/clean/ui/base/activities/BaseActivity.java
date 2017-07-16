package ru.alexbykov.androidcleanarchitecture.clean.ui.base.activities;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;

import ru.alexbykov.androidcleanarchitecture.R;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.BaseLifeCycle;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.NavigatorActivityView;
import ru.alexbykov.androidcleanarchitecture.clean.ui.utils.KeyboardHelper;
import ru.alexbykov.androidcleanarchitecture.clean.ui.utils.Navigator;

/**
 * Date: 15.07.2017
 * Time: 22:12
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public abstract class BaseActivity extends MvpAppCompatActivity implements NavigatorActivityView, BaseLifeCycle {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUI();
        setupUX();
    }

    protected final void hideKeyboard() {
        KeyboardHelper.hide(this);
    }

    protected final void hideView(@NonNull View view) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.GONE);
        }
    }

    protected final void showView(@NonNull View view) {
        if (view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public final void startActivity(Class<? extends BaseActivity> activityClass) {
        Navigator.startActivity(this, activityClass);
    }

    @Override
    public final void startActivityForResult(Class<? extends BaseActivity> activityClass, int requestCode) {
        Navigator.startActivityForResult(this, activityClass, requestCode);
    }

    @Override
    public final void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation);
    }


    @SuppressWarnings("unchecked")
    protected final <T extends View> T bindView(@IdRes int id) {
        return (T) findViewById(id);
    }


    @SuppressWarnings("unchecked")
    protected final int bindColor(@ColorRes int id) {
        return ContextCompat.getColor(this, id);
    }


    @SuppressWarnings("unchecked")
    protected final String bindString(@StringRes int id) {
        return getString(id);
    }

    @SuppressWarnings("unchecked")
    protected final int bindDimen(@DimenRes int id) {
        return (int) getResources().getDimension(id);
    }


}
