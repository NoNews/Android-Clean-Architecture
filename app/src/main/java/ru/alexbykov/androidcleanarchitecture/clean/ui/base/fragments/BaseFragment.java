package ru.alexbykov.androidcleanarchitecture.clean.ui.base.fragments;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.arellomobile.mvp.MvpAppCompatFragment;

import ru.alexbykov.androidcleanarchitecture.clean.ui.base.BaseLifeCycle;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.NavigatorActivityView;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.activities.BaseActivity;
import ru.alexbykov.androidcleanarchitecture.clean.ui.utils.KeyboardHelper;
import ru.alexbykov.androidcleanarchitecture.clean.ui.utils.Navigator;

/**
 * Date: 16.07.2017
 * Time: 15:25
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public abstract class BaseFragment extends MvpAppCompatFragment implements NavigatorActivityView, BaseLifeCycle {

    protected final String TAG = getClass().getSimpleName();
    protected View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setupUI();
        setupUX();
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    public final void hideKeyboard() {
        KeyboardHelper.hide(getActivity());
    }

    @Override
    public final void startActivity(Class<? extends BaseActivity> activityClass) {
        Navigator.startActivity(getActivity(), activityClass);
    }

    @Override
    public final void startActivityForResult(Class<? extends BaseActivity> activityClass, int requestCode) {
        Navigator.startActivityForResult(getActivity(), activityClass, requestCode);
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
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (Navigator.isFragmentAnimationDisabled) {
            Animation a = new Animation() {
            };
            a.setDuration(0);
            return a;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }


    @SuppressWarnings("unchecked")
    protected final <T extends View> T bindView(@IdRes int id) {
        return (T) rootView.findViewById(id);
    }


    @SuppressWarnings("unchecked")
    protected final int bindDimen(@DimenRes int id) {
        return (int) getResources().getDimension(id);
    }

    @SuppressWarnings("unchecked")
    protected final int bindColor(@ColorRes int id) {
        return ContextCompat.getColor(getContext(), id);
    }


    @SuppressWarnings("unchecked")
    protected final String bindString(@StringRes int id) {
        return getString(id);
    }



}
