package ru.alexbykov.androidcleanarchitecture.clean.ui.base;

import ru.alexbykov.androidcleanarchitecture.clean.ui.base.activities.BaseActivity;
import ru.alexbykov.androidcleanarchitecture.clean.ui.base.views.BaseView;

/**
 * Date: 16.07.2017
 * Time: 15:24
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */

public interface NavigatorActivityView extends BaseView {
    void startActivity(Class<? extends BaseActivity> activityClass);
    void startActivityForResult(Class<? extends BaseActivity> activityClass, int requestCode);
}
