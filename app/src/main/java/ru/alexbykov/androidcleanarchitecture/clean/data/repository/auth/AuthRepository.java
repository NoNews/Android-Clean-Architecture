package ru.alexbykov.androidcleanarchitecture.clean.data.repository.auth;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import ru.alexbykov.androidcleanarchitecture.clean.data.enity.UserDTO;
import ru.alexbykov.androidcleanarchitecture.clean.data.network.RestApi;
import ru.alexbykov.androidcleanarchitecture.clean.data.repository.BaseRepository;
import ru.alexbykov.androidcleanarchitecture.clean.ui.keys.auth.presenters.ModelCallback;
import ru.alexbykov.androidcleanarchitecture.system.utils.RxUtils;
import ru.alexbykov.androidcleanarchitecture.system.utils.Utils;

/**
 * Date: 16.07.2017
 * Time: 14:41
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class AuthRepository extends BaseRepository {


    public static final String MOCK_LOGIN = "admin@admin.ru";
    public static final String MOCK_PASSWORD = "password";

    private RestApi restApi;
    private ModelCallback modelCallback;

    public AuthRepository(RestApi restApi) {
        this.restApi = restApi;
    }

    public void getUser(ModelCallback userCallback) {
        setModelCallback(userCallback);
        Observable.timer(Utils.httpRandomTime(), TimeUnit.SECONDS)
                .map(aLong -> getMockUser())
                .compose(RxUtils.httpSchedulers())
                .subscribe(this::successGetUser, this::handleError);

    }

    @NonNull
    private UserDTO getMockUser() {
        return new UserDTO();
    }


    public void regUser(ModelCallback userCallback, String email, String password) {
        setModelCallback(userCallback);

        Observable.timer(Utils.httpRandomTime(), TimeUnit.SECONDS)
                .map(aLong -> getMockUser())
                .compose(RxUtils.httpSchedulers())
                .subscribe(this::successGetUser, this::handleError);

    }

    public void loginUser(ModelCallback userCallback, String email, String password) {
        setModelCallback(userCallback);

        if (!email.equals(MOCK_LOGIN) || !password.equals(MOCK_PASSWORD)) {
            userCallback.handleError("Неправильное имя пользователя или пароль");
        } else {
            Observable.timer(Utils.httpRandomTime(), TimeUnit.SECONDS)
                    .map(aLong -> getMockUser())
                    .compose(RxUtils.httpSchedulers())
                    .subscribe(this::successGetUser, this::handleError);
        }

    }

    private void setModelCallback(ModelCallback modelCallback) {
        this.modelCallback = null;
        this.modelCallback = modelCallback;
    }


    private void handleError(Throwable throwable) {
        modelCallback.handleError("Нет интернета");
    }


    private void successGetUser(UserDTO user) {
        modelCallback.successGetUser(user);
    }
}
