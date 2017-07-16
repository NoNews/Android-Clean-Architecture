package ru.alexbykov.androidcleanarchitecture.di.modules;

import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.alexbykov.androidcleanarchitecture.clean.data.network.RestApi;
import ru.alexbykov.androidcleanarchitecture.clean.data.network.TokenHelper;
import ru.alexbykov.androidcleanarchitecture.clean.data.repository.auth.AuthRepository;
import ru.alexbykov.androidcleanarchitecture.clean.domain.auth.AuthInteractor;
import ru.alexbykov.androidcleanarchitecture.system.App;

/**
 * Date: 04.06.2017
 * Time: 10:46
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */

@Module
public class RestModule {

    private TokenHelper tokenHelper;
    private RestApi restApi;
    private AuthInteractor authInteractor;
    private AuthRepository authRepository;

    public RestModule(App app) {
        tokenHelper = new TokenHelper(PreferenceManager.getDefaultSharedPreferences(app));
        restApi = new RestApi(tokenHelper);
        authRepository = new AuthRepository(restApi);
        authInteractor = new AuthInteractor(authRepository);
    }


    @Singleton
    @Provides
    AuthRepository provideAuthRepository() {
        return authRepository;
    }

    @Singleton
    @Provides
    AuthInteractor provideAuthInteractor() {
        return authInteractor;
    }

    @Singleton
    @Provides
    RestApi provideRestApi() {
        return restApi;
    }

    @Singleton
    @Provides
    TokenHelper provideTokenHelper() {
        return tokenHelper;
    }
}

