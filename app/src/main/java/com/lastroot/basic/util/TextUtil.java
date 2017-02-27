package com.lastroot.basic.util;

import android.util.Patterns;

/**
 * Created by Truong Quoc Khanh on 2/27/2017.
 */

public class TextUtil {

    public static boolean verifyEmail(String email) {
        return !(email == null || email.isEmpty()) && Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches();
    }

    public static boolean verifyPassword(String password) {
        return !(password == null || password.isEmpty());
    }
}
