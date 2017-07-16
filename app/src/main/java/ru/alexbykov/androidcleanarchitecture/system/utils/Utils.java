package ru.alexbykov.androidcleanarchitecture.system.utils;

import java.util.Random;

/**
 * Date: 16.07.2017
 * Time: 18:25
 * Project: AndroidCleanArchitecture
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class Utils {


    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int httpRandomTime() {
        return getRandom(1, 4);
    }
}
