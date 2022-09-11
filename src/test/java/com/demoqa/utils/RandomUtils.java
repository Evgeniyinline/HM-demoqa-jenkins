package com.demoqa.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String getRandomGender() {
        String[] arr = {"Female", "Male", "Other"};
        int randIdx = ThreadLocalRandom.current().nextInt(arr.length);
        String randomElem = arr[randIdx];
        return randomElem;
    }
    public static String getRandomMonth() {
        String[] arr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int randIdx = ThreadLocalRandom.current().nextInt(arr.length);
        String randomElem = arr[randIdx];
        return randomElem;
    }
    public static String getRandomHobby() {
        String[] arr = {"Sports", "Reading", "Music"};
        int randIdx = ThreadLocalRandom.current().nextInt(arr.length);
        String randomElem = arr[randIdx];
        return randomElem;
    }


}