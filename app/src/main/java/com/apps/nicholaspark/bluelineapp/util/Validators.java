package com.apps.nicholaspark.bluelineapp.util;

import java.util.regex.Pattern;

import static com.apps.nicholaspark.bluelineapp.util.Strings.isBlank;


public final class Validators {
  private static final Pattern EMAIL_ADDRESS = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" +
      "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");

  private Validators() {
    throw new AssertionError("No instances");
  }

  public static boolean isEmail(String email) {
    return isMatch(email, EMAIL_ADDRESS);
  }

  private static boolean isMatch(String str, Pattern pattern) {
    if (isBlank(str)) {
      return false;
    }

    return pattern.matcher(str.trim()).matches();
  }
}