package ru.alexbykov.androidcleanarchitecture.clean.data.network;

import android.content.SharedPreferences;

/**
 * Date: 15.07.2017
 * Time: 22:25
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class TokenHelper {

    private static final String PREF_TOKEN_API = "tokenAPI";
    private SharedPreferences preferences;
    private String token;

    public TokenHelper(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public String getToken() {
        if (token == null) token = preferences.getString(PREF_TOKEN_API, "");
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        preferences.edit().putString(PREF_TOKEN_API, token).apply();
    }

    public boolean isFirstRun() {
        return !preferences.contains(PREF_TOKEN_API);
    }

    public void exit() {
        preferences.edit().clear().apply();
    }
}
