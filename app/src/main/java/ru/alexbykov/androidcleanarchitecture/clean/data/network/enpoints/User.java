package ru.alexbykov.androidcleanarchitecture.clean.data.network.enpoints;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.alexbykov.androidcleanarchitecture.clean.data.enity.UserDTO;

/**
 * Date: 15.07.2017
 * Time: 22:27
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public interface User {


    @GET("/get")
    Observable<UserDTO> get();

    @GET("/reg")
    Observable<UserDTO> reg(@Query("email") String email, @Query("password") String password);

    @GET("/login")
    Observable<UserDTO> login(@Query("email") String email, @Query("password") String password);

}
