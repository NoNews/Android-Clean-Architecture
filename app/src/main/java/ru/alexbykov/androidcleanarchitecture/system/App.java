package ru.alexbykov.androidcleanarchitecture.system;

import android.app.Application;

import ru.alexbykov.androidcleanarchitecture.di.Injector;
import ru.alexbykov.androidcleanarchitecture.di.components.DaggerPresenterComponent;
import ru.alexbykov.androidcleanarchitecture.di.components.DaggerViewComponent;
import ru.alexbykov.androidcleanarchitecture.di.components.PresenterComponent;
import ru.alexbykov.androidcleanarchitecture.di.components.ViewComponent;
import ru.alexbykov.androidcleanarchitecture.di.modules.RestModule;
import ru.alexbykov.androidcleanarchitecture.di.modules.UtilsModule;
import ru.alexbykov.androidcleanarchitecture.di.modules.ViewModule;


/**
 * Date: 15.07.2017
 * Time: 21:59
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        setupDagger2();
    }

    private void setupDagger2() {
        PresenterComponent presenterComponent = DaggerPresenterComponent.builder()
                .restModule(new RestModule(this))
                .utilsModule(new UtilsModule(this))
                .build();
        presenterComponent.inject(this);

        ViewComponent viewComponent = DaggerViewComponent.builder()
                .viewModule(new ViewModule(this))
                .build();
        viewComponent.inject(this);

        Injector.setPresenterComponent(presenterComponent);
        Injector.setViewComponent(viewComponent);
    }

}
