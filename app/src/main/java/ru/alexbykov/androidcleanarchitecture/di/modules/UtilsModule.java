package ru.alexbykov.androidcleanarchitecture.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.alexbykov.androidcleanarchitecture.clean.domain.auth.AuthInteractor;
import ru.alexbykov.androidcleanarchitecture.clean.ui.utils.Resources;
import ru.alexbykov.androidcleanarchitecture.system.App;

/**
 * Date: 04.06.2017
 * Time: 11:06
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */

@Module
public class UtilsModule {

    private App app;

    public UtilsModule(App app) {
        this.app = app;
    }




    @Provides
    Resources provideResources() {
        return new Resources(app);
    }

}
