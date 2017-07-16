package ru.alexbykov.androidcleanarchitecture.di;

import ru.alexbykov.androidcleanarchitecture.di.components.PresenterComponent;
import ru.alexbykov.androidcleanarchitecture.di.components.ViewComponent;

/**
 * Date: 15.07.2017
 * Time: 22:14
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class Injector {



    private Injector(){}

    private static PresenterComponent presenterComponent;
    private static ViewComponent viewComponent;

    public static PresenterComponent getPresenterComponent() {
        return presenterComponent;
    }

    public static void setPresenterComponent(PresenterComponent presenterComponent) {
        Injector.presenterComponent = presenterComponent;
    }

    public static ViewComponent getViewComponent() {
        return viewComponent;
    }

    public static void setViewComponent(ViewComponent viewComponent) {
        Injector.viewComponent = viewComponent;
    }


}
