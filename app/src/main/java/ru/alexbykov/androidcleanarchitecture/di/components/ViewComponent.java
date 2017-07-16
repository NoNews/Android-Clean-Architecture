package ru.alexbykov.androidcleanarchitecture.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.alexbykov.androidcleanarchitecture.di.modules.ViewModule;
import ru.alexbykov.androidcleanarchitecture.system.App;

/**
 * Date: 04.06.2017
 * Time: 10:30
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */


@Singleton
@Component(modules = {ViewModule.class})
public interface ViewComponent {
    void inject(App app);
}
