package ru.alexbykov.androidcleanarchitecture.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.alexbykov.androidcleanarchitecture.clean.data.repository.auth.AuthRepository;
import ru.alexbykov.androidcleanarchitecture.clean.domain.auth.AuthInteractor;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters.LoginPresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters.RegOrLoginPresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters.AuthPresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters.SplashPresenter;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.main_menu.presenters.MainPresenter;
import ru.alexbykov.androidcleanarchitecture.di.modules.RestModule;
import ru.alexbykov.androidcleanarchitecture.di.modules.UtilsModule;
import ru.alexbykov.androidcleanarchitecture.system.App;


/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */


@Singleton
@Component(modules = {RestModule.class, UtilsModule.class})

public interface PresenterComponent {
    void inject(App app);
    AuthPresenter getAuthPresenter();
    void inject(AuthInteractor authInteractor);
    void inject(AuthRepository authRepository);
    SplashPresenter getSplashPresenter();
    MainPresenter getMainPresenter();
    RegOrLoginPresenter getAuthOrAuthPresenter();
    LoginPresenter getLoginPresenter();

}
